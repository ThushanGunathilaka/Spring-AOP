package com.mtit.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mtit.dataaccess.UserDao;
import com.mtit.model.User;
import com.mtit.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void add(User user) {
		userDao.add(user);
	}

	@Transactional
	public void edit(User user) {
		userDao.edit(user);
	}

	@Transactional
	public void delete(int userId) {
		userDao.delete(userId);
	}

	@Transactional
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Transactional
	public int login(String username, String password) {
		return userDao.login(username, password);
	}

}
