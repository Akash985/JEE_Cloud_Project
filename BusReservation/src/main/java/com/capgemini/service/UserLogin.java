package com.capgemini.service;

import com.capgemini.model.User;

public interface UserLogin {

	//@@validateUserName
		User validateUserName(String userName);
		
		//@@
		//Validate passwaord
		boolean passwordVerification(User user,String password);
}
