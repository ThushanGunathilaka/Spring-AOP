package com.mtit.service;

import java.util.List;

import com.mtit.model.AccountHolder;

public interface AccountHolderService {
	public void add(AccountHolder accountHolder);
	public void edit(AccountHolder accountHolder);
	public void delete(int accountHolderId);
	public AccountHolder getAccountHolder(int accountHolderId);
	@SuppressWarnings("rawtypes")
	public List getAllAccountHolders();
}
