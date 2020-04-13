package com.capgemini.dao;

import com.capgemini.exception.PhoneNumberExistsException;
import com.capgemini.exception.UserNameExistsException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;

public interface UserDao {
	
	boolean validateDetails(User user)throws UserNameExistsException,PhoneNumberExistsException;
	//if Username, mobile number already exist then return string carryig that information
	//that means you have to create exception over there
	//do we have to create 2 types of exception relating  Username, mobile number
	//if details is unique then return false
	boolean createNewUser(User user) ;
	boolean deleteOldUser(User user);
	User getUserByUserName(String userName) throws UserNotFoundException;

}
