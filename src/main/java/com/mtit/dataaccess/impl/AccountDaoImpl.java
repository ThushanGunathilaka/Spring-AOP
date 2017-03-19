package com.mtit.dataaccess.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mtit.dataaccess.AccountDao;
import com.mtit.model.Account;
@Repository
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private SessionFactory session;
	@Override
	public void add(Account account) {
		session.getCurrentSession().save(account);
	}

	@Override
	public void edit(Account account) {
		session.getCurrentSession().update(account);
	}

	@Override
	public void delete(int accountId) {
		session.getCurrentSession().delete(getAccount(accountId));
	}

	@Override
	public Account getAccount(int accountId) {
		return (Account)session.getCurrentSession().get(Account.class, accountId);
	}

	@Override
	public List getAllAccounts() {
		return session.getCurrentSession().createQuery("from Account").list();
	}

}
