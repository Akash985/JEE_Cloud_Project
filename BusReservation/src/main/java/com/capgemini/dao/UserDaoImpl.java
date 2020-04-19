package com.capgemini.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capgemini.exception.PhoneNumberExistsException;
import com.capgemini.exception.UserNameExistsException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;

public class UserDaoImpl implements UserDao{

	private static List<User> userList = new ArrayList<User>();

	static {
		//this is created to have some data initially in our in-memory database
		User user1 = new User("Atharva", "AtharvaP1997", "22222222", 'M', 21, 7856124389L);
		User user2 = new User("Arun", "Arun1997", "88888888", 'M', 22, 9867915595L);
		User user3 = new User("Akash", "AkashY1997", "11111111", 'M',23,7788995642L);
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
	}

	
	
	//validate user
	@Override
	public boolean validateDetails(User user) throws UserNameExistsException,PhoneNumberExistsException{
		boolean flag = true;
		Iterator<User> itr = userList.iterator();
		while (itr.hasNext()) {
			User tempUser = itr.next();
			if(user.getUserName().equals(tempUser.getUserName())) {
				flag = false;
				throw new UserNameExistsException(tempUser.getUserName());
			}else if(user.getPhoneNumber()==tempUser.getPhoneNumber()) {
				flag = false;
				throw new PhoneNumberExistsException(tempUser.getPhoneNumber());
			}else {
				flag = true;
			}	
		}
		return flag;
	}

	
	//add user
	@Override
	public boolean createNewUser(User user) {
		boolean result = userList.add(user);
		return result;
	}

	
	//delete user
	@Override
	public boolean deleteOldUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public User getUserByUserName(String userName) throws UserNotFoundException {
		Iterator<User> itr = userList.iterator();
		User tempUser = null;
		while (itr.hasNext()) {
			tempUser = itr.next();
			if (userName.equals(tempUser.getUserName())) {
				break;
			}
			tempUser = null;
		}
		if (tempUser==null) {
			throw new UserNotFoundException(userName); 
		}else {
			return tempUser;	
		}
		
	}
	
}
