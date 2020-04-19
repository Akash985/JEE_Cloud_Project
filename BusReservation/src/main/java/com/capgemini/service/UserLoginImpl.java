package com.capgemini.service;

import com.capgemini.dao.UserDao;
import com.capgemini.dao.UserDaoImpl;
import com.capgemini.exception.InvalidUserPasswordException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;

public class UserLoginImpl implements UserLogin {
		private static UserDao userDao = new UserDaoImpl();
	
		
		@Override
		public User validateUserName(String userName) throws UserNotFoundException {	
			User user = null;	
			user = userDao.getUserByUserName(userName);		
			return user;
		}
		
		@Override
		public boolean passwordVerification(User user, String password) throws InvalidUserPasswordException {
			
			if(password.equals(user.getUserPassword())) {
				return true;
			}else {
				throw new InvalidUserPasswordException();
			}
		}

}
