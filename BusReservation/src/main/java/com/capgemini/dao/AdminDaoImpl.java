package com.capgemini.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.Admin;



public class AdminDaoImpl implements AdminDao {
	private static List<Admin> adminList = new ArrayList<Admin>();

	static {
		//this is created to have some data initially in our in-memory database
		Admin admin1 = new Admin("Atharva", "admin1", "atharva",1001, 'M', 21);
		Admin admin2 = new Admin("Arun", "admin2", "arun", 1002, 'M', 22);
		Admin admin3 = new Admin("Akash", "admin3", "akash", 1003, 'M',23);
		adminList.add(admin1);
		adminList.add(admin2);
		adminList.add(admin3);

	}
	@Override
	public Admin getAdminbyUserName(String adminUserName) throws UserNotFoundException {
		Iterator<Admin> itr = adminList.iterator();
		Admin tempAdmin = null;
		while (itr.hasNext()) {
			tempAdmin = itr.next();
			if (adminUserName.equals(tempAdmin.getAdminUserName())) {
				break;
			}
			tempAdmin = null;
		}
		if (tempAdmin==null) {
			throw new UserNotFoundException(adminUserName); 
		}else {
			return tempAdmin;	
		}
		
	}
	}


