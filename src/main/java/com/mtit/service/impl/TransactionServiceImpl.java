package com.mtit.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mtit.dataaccess.TransactionDao;
import com.mtit.exception.BalanceNotSufficientException;
import com.mtit.exception.InvalidAccountException;
import com.mtit.exception.NoAccountException;
import com.mtit.model.Account;
import com.mtit.model.AccountHolder;
import com.mtit.model.Transaction;
import com.mtit.service.AccountHolderService;
import com.mtit.service.AccountService;
import com.mtit.service.TransactionService;
@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionDao transactionDao;
	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountHolderService accountHolderService;
	
	private Account account;
	private AccountHolder accountHolder;
	
	@Transactional
	public void add(Transaction transaction) {
		transactionDao.add(transaction);
	}
	@Transactional
	public void edit(Transaction transaction) {
		transactionDao.edit(transaction);
	}
	@Transactional
	public Transaction getTransaction(int transactionId) {
		return transactionDao.getTransaction(transactionId);
	}

	@Transactional
	public List getAllTransactions() {
		return transactionDao.getAllTransactions();
	}
	@Transactional
	public Transaction withdraw(int amount) throws BalanceNotSufficientException {
		int balance = account.getBalance();
		if(account.getBalance()<amount){
			throw new BalanceNotSufficientException("Your balance is not sufficient to complete transaction.");
		}
		else{
			account.setBalance(balance-amount);
			accountService.edit(account);
			return addTransaction("Withdraw", amount);
		}
	}
	@Transactional
	public Transaction deposit(int amount) {
		int balance = account.getBalance();
		balance = balance + amount;
		account.setBalance(balance);
		accountService.edit(account);
		return addTransaction("Deposit", amount);
	}
	@Transactional
	public boolean validate(int accountId, int accountHolderId) throws InvalidAccountException, NoAccountException{
		if(accountId != accountHolderId){
			throw new NoAccountException("No registered account for given account no.");
		}else{
			this.account = accountService.getAccount(accountId);
			this.accountHolder = accountHolderService.getAccountHolder(accountHolderId);
			if(this.account!=null && this.accountHolder!=null){
				return true;
			}
			else{
				throw new InvalidAccountException("Account No are not valid.");
			}
		}
	}
	
	public Transaction addTransaction(String type,int amount){
		Date date = new Date();
		Transaction transaction = new Transaction();
		transaction.setTransactionAccountHolderId(accountHolder.getAccountHolderId());
		transaction.setTransactionAccountId(account.getAccountId());
		transaction.setTransactionAmount(amount);
		transaction.setTransactionDate(date);
		transaction.setTransactionType(type);
		return transaction;
	}

}
