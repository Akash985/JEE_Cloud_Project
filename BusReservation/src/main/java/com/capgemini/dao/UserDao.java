package com.capgemini.dao;

import com.capgemini.exception.PhoneNumberExistsException;
import com.capgemini.exception.UserNameExistsException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;

public interface UserDao {
	
	boolean validateDetails(User user)throws UserNameExistsException,PhoneNumberExistsException;
	boolean createNewUser(User user) ;
	boolean deleteOldUser(User user);
	User getUserByUserName(String userName) throws UserNotFoundException;

}
