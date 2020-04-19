package com.capgemini.service;

import com.capgemini.exception.InvalidUserPasswordException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.Admin;

public interface AdminLogin {
	Admin validateadminUserName(String adminUserName) throws UserNotFoundException;
	boolean passwordVerification(Admin admin,String adminPassword) throws InvalidUserPasswordException;

}
