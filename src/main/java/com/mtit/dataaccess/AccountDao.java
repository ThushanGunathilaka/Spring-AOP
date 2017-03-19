package com.mtit.dataaccess;

import java.util.List;

import com.mtit.model.Account;

public interface AccountDao {
	public void add(Account account);
	public void edit(Account account);
	public void delete(int accountId);
	public Account getAccount(int accountId);
	@SuppressWarnings("rawtypes")
	public List getAllAccounts();
}
