package com.mtit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mtit.dataaccess.AccountHolderDao;
import com.mtit.model.AccountHolder;
import com.mtit.service.AccountHolderService;
@Service
public class AccountHolderServiceImpl implements AccountHolderService {
	@Autowired
	private AccountHolderDao accountHolderDao;
	@Transactional
	public void add(AccountHolder accountHolder) {
		accountHolderDao.add(accountHolder);
	}

	@Transactional
	public void edit(AccountHolder accountHolder) {
		accountHolderDao.edit(accountHolder);
	}

	@Transactional
	public void delete(int accountHolderId) {
		accountHolderDao.delete(accountHolderId);
	}

	@Transactional
	public AccountHolder getAccountHolder(int accountHolderId) {
		return accountHolderDao.getAccountHolder(accountHolderId);
	}

	@Transactional
	public List getAllAccountHolders() {
		return accountHolderDao.getAllAccountHolders();
	}

}
