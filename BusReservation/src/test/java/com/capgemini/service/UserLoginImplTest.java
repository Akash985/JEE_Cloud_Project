 package com.capgemini.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.exception.InvalidUserPasswordException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;

public class UserLoginImplTest {
	User user1 = null;
	UserLogin userLogin= null;
	
	@Before
	public void setUp() {
		userLogin= new UserLoginImpl();
		user1 = new User("Atharva", "AtharvaP1997", "22222222", 'M', 21, 7856124389L);
	}
	
	@After
	public void teardown() {
		user1 = null;
	}
	

	
	@Test
	public void testValidateUserNameForUserNameExist() {
		
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
		UserLogin userLogin= new UserLoginImpl();
		try {
			assertTrue(userLogin.passwordVerification(user1, "22222222"));
		} catch (InvalidUserPasswordException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	@Test
	public void testPasswordVerificationFailed() {
		UserLogin userLogin= new UserLoginImpl();
		try {
			assertFalse(userLogin.passwordVerification(user1, "11111111"));
		} catch (InvalidUserPasswordException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	
	@Test(expected = InvalidUserPasswordException.class)
	public void testPasswordVerificationInvalidUserPassworException() throws InvalidUserPasswordException {
		UserLogin userLogin= new UserLoginImpl();
		assertFalse(userLogin.passwordVerification(user1, "11111111"));
	}
	
	
}
