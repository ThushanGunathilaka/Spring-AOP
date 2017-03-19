package com.mtit.dataaccess.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mtit.dataaccess.AccountHolderDao;
import com.mtit.model.Account;
import com.mtit.model.AccountHolder;
@Repository
public class AccountHolderDaoImpl implements AccountHolderDao {
	@Autowired
	private SessionFactory session;
	@Override
	public void add(AccountHolder accountHolder) {
		session.getCurrentSession().save(accountHolder);
	}

	@Override
	public void edit(AccountHolder accountHolder) {
		session.getCurrentSession().update(accountHolder);
	}

	@Override
	public void delete(int accountHolderId) {
		session.getCurrentSession().delete(getAccountHolder(accountHolderId));
	}

	@Override
	public AccountHolder getAccountHolder(int accountHolderId) {
		return (AccountHolder)session.getCurrentSession().get(AccountHolder.class, accountHolderId);
	}

	@Override
	public List getAllAccountHolders() {
		return session.getCurrentSession().createQuery("from AccountHolder").list();
	}

}
