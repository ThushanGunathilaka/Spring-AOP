package com.mtit.dataaccess.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mtit.dataaccess.TransactionDao;
import com.mtit.model.Account;
import com.mtit.model.AccountHolder;
import com.mtit.model.Transaction;
@Repository
public class TransactionDaoImpl implements TransactionDao{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Transaction transaction) {
		session.getCurrentSession().save(transaction);
	}

	@Override
	public void edit(Transaction transaction) {
		session.getCurrentSession().update(transaction);
	}

	@Override
	public Transaction getTransaction(int transactionId) {
		return (Transaction)session.getCurrentSession().get(Account.class, transactionId);
	}

	@Override
	public List getAllTransactions() {
		return session.getCurrentSession().createQuery("from Transaction").list();
	}

}
