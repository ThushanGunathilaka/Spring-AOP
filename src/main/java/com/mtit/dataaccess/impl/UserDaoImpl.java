package com.mtit.dataaccess.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mtit.dataaccess.UserDao;
import com.mtit.model.Account;
import com.mtit.model.User;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory session;
	@Override
	public void add(User user) {
		session.getCurrentSession().save(user);
		
	}

	@Override
	public void edit(User user) {
		session.getCurrentSession().update(user);
		
	}

	@Override
	public void delete(int userId) {
		session.getCurrentSession().delete(getUser(userId));
		
	}

	@Override
	public User getUser(int userId) {
		return (User)session.getCurrentSession().get(User.class, userId);
	}

	@Override
	public int login(String username, String password) {
		List res = session.getCurrentSession().createSQLQuery("select u.Id from USER u  where u.username='"+username+"' and u.password='"+password+"'").list();
		if(res.size()>0){
			return (int) res.get(0);
		}
		return res.size();
	}

}
