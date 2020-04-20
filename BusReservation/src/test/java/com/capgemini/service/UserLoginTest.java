 package com.capgemini.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.capgemini.exception.InvalidUserPasswordException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;

public class UserLoginTest {

	
	@Test
	public void testValidateUserNameForUserNameExist() {
		User user1 = new User("Atharva", "AtharvaP1997", "22222222", 'M', 21, 7856124389L);
		UserLogin userLogin= new UserLoginImpl();
		User user2 = null;
		try {
			user2 = userLogin.validateUserName(user1.getUserName());
			user1.equals(user2);
		} catch (UserNotFoundException e) {
			e.getMessage();
		}
		 
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testValidateUserNameUserNotFoundException() throws UserNotFoundException {
		UserLogin userLogin= new UserLoginImpl();
		User user2 = userLogin.validateUserName("Aaa123");		
	}
	
	@Test
	public void testPasswordVerificationPassed() {
		User user1 = new User("Atharva", "AtharvaP1997", "22222222", 'M', 21, 7856124389L);
		UserLogin userLogin= new UserLoginImpl();
		try {
			assertTrue(userLogin.passwordVerification(user1, "22222222"));
		} catch (InvalidUserPasswordException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	@Test
	public void testPasswordVerificationFailed() {
		User user1 = new User("Atharva", "AtharvaP1997", "22222222", 'M', 21, 7856124389L);
		UserLogin userLogin= new UserLoginImpl();
		try {
			assertFalse(userLogin.passwordVerification(user1, "11111111"));
		} catch (InvalidUserPasswordException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	
	@Test(expected = InvalidUserPasswordException.class)
	public void testPasswordVerificationInvalidUserPassworException() throws InvalidUserPasswordException {
		User user1 = new User("Atharva", "AtharvaP1997", "22222222", 'M', 21, 7856124389L);
		UserLogin userLogin= new UserLoginImpl();
		assertFalse(userLogin.passwordVerification(user1, "11111111"));
	}
	
	
}
