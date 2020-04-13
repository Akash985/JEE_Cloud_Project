package com.capgemini.service;

import com.capgemini.dao.UserDao;
import com.capgemini.dao.UserDaoImpl;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;

public class UserLoginImpl implements UserLogin {
	private static UserDao userDao = new UserDaoImpl();

	@Override
	public User validateUserName(String userName) {
		
		User user = null;
		try {
			user = userDao.getUserByUserName(userName);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}		
		return user;
	}
	
	@Override
	public boolean passwordVerification(User user, String password) {
		
		if(password.equals(user.getUserPassword())) {
			return true;
		}else {
			//here you have to create InvalidUSerException in exception package and handle in this function
			return false;
		}
	}

}
