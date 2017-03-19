package com.mtit.service.impl;

import org.springframework.aop.BeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mtit.dataaccess.UserDao;
import com.mtit.model.User;
import com.mtit.service.UserValidationService;

@Service
public class UserValidationServiceImpl implements UserValidationService {
	@Autowired
	private UserDao userDao;

	@Transactional
	public boolean validateDepCurrentUser(int userId) {
		User user = userDao.getUser(userId);
		if (user.getRole().equals("ADMIN")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean validateWithCurrentUser(int userId) {
		User user = userDao.getUser(userId);
		if (user.getRole().equals("SUPERADMIN")) {
			return true;
		}
		return false;
	}

}
