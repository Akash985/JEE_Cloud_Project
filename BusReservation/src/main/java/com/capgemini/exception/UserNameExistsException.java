package com.capgemini.exception;

public class UserNameExistsException extends Exception{

	private String userName;
	
	public UserNameExistsException() {
		super();
	}



	public UserNameExistsException(String userName) {
		super();
		this.userName = userName;
	}



	@Override
	public String toString() {
		return userName + "UserName already exist";
	}
	
	@Override
	public String getMessage() {		
		return userName + "UserName already exist";
	}	
}
