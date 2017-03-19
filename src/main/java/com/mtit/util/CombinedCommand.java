package com.mtit.util;

import java.util.List;

import com.mtit.model.Account;
import com.mtit.model.AccountHolder;
import com.mtit.model.Transaction;

public class CombinedCommand {
	Account account;
	AccountHolder accountHolder;
	Transaction transaction;
	List<Account> accountList;
	List<AccountHolder> accountHolderList;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public List<AccountHolder> getAccountHolderList() {
		return accountHolderList;
	}

	public void setAccountHolderList(List<AccountHolder> accountHolderList) {
		this.accountHolderList = accountHolderList;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
