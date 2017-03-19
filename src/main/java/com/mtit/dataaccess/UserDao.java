package com.mtit.dataaccess;

import com.mtit.model.User;

public interface UserDao {
	public void add(User user);
	public void edit(User user);
	public void delete(int userId);
	public User getUser(int userId);
	public int login(String username,String password);
}
