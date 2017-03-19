package com.mtit.service;

import java.util.List;

import com.mtit.model.Account;

public interface AccountService {
	public void add(Account account);
	public void edit(Account account);
	public void delete(int accountId);
	public Account getAccount(int accountId);
	@SuppressWarnings("rawtypes")
	public List getAllAccounts();
}
