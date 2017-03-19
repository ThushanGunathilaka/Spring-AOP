package com.mtit.service;

import java.util.List;

import com.mtit.exception.BalanceNotSufficientException;
import com.mtit.exception.InvalidAccountException;
import com.mtit.exception.NoAccountException;
import com.mtit.model.Transaction;

public interface TransactionService {
	public void add(Transaction transaction);
	public void edit(Transaction transaction);
	public Transaction getTransaction(int transactionId);
	@SuppressWarnings("rawtypes")
	public List getAllTransactions();
	public Transaction withdraw(int amount) throws BalanceNotSufficientException;
	public Transaction deposit(int amount);
	public boolean validate(int accountId,int accountHolderId) throws InvalidAccountException, NoAccountException;
}
