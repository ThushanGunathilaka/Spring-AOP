package com.mtit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mtit.dataaccess.AccountDao;
import com.mtit.model.Account;
import com.mtit.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDao accountDao;
	@Transactional
	public void add(Account account) {
		accountDao.add(account);
	}

	@Transactional
	public void edit(Account account) {
		accountDao.edit(account);
	}

	@Transactional
	public void delete(int accountId) {
		accountDao.delete(accountId);		
	}

	@Transactional
	public Account getAccount(int accountId) {
		return accountDao.getAccount(accountId);
	}

	@Transactional
	public List getAllAccounts() {
		return accountDao.getAllAccounts();
	}

}
