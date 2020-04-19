package com.capgemini.service;

import com.capgemini.dao.AdminDao;
import com.capgemini.dao.AdminDaoImpl;
import com.capgemini.exception.InvalidUserPasswordException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.Admin;

public class AdminLoginImpl implements AdminLogin{
	private static AdminDao adminDao = new AdminDaoImpl();

	@Override
	public Admin validateadminUserName(String adminUserName) throws UserNotFoundException {
		Admin admin=null;
		try {
			admin=adminDao.getAdminbyUserName(adminUserName);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}		
		return admin;
		
	}

	@Override
	public boolean passwordVerification(Admin admin, String adminPassword) throws InvalidUserPasswordException {
		if(adminPassword.equals(admin.getAdminPassword())) {
			return true;
		}else {
			throw new InvalidUserPasswordException();
		}
	}

}
