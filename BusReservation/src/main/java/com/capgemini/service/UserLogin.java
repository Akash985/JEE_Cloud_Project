package com.capgemini.service;

import com.capgemini.exception.InvalidUserPasswordException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;

public interface UserLogin {

		//@@validateUserName
		User validateUserName(String userName) throws UserNotFoundException;
		
		//@@
		//Validate passwaord
		boolean passwordVerification(User user,String password) throws InvalidUserPasswordException;
}