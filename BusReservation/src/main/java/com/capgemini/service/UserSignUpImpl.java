package com.capgemini.service;

import com.capgemini.dao.UserDao;
import com.capgemini.dao.UserDaoImpl;
import com.capgemini.exception.PhoneNumberExistsException;
import com.capgemini.exception.UserNameExistsException;
import com.capgemini.model.User;

public class UserSignUpImpl implements UserSignUp {

	private static UserDao userDao = new UserDaoImpl();
	@Override
	public boolean signUp(User user) throws UserNameExistsException, PhoneNumberExistsException {		
		
		boolean flag = false;
		boolean result = false;
		flag = userDao.validateDetails(user);//if flag is false user exists and (if flag is true user does not exist and 
												//we can add user)
		
		if(flag) {
			result = userDao.createNewUser(user);
			return result;
		}else {
			return result;
		}		
	}

}
