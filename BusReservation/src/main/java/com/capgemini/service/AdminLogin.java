package com.capgemini.service;

import com.capgemini.model.Admin;

public interface AdminLogin {
	Admin validateadminUserName(String adminUserName);
	boolean passwordVerification(Admin admin,String adminPassword);

}
