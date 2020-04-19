package com.capgemini.service;

import com.capgemini.exception.PhoneNumberExistsException;
import com.capgemini.exception.UserNameExistsException;
import com.capgemini.model.User;

public interface UserSignUp {
	
	
	public boolean signUp(User user) throws UserNameExistsException, PhoneNumberExistsException;
	

}
