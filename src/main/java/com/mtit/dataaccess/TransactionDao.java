package com.mtit.dataaccess;

import java.util.List;

import com.mtit.model.Transaction;

public interface TransactionDao {
	public void add(Transaction transaction);
	public void edit(Transaction transaction);
	public Transaction getTransaction(int transactionId);
	@SuppressWarnings("rawtypes")
	public List getAllTransactions();
}
