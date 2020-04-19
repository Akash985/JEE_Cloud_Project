package com.capgemini.exception;

public class UserNotFoundException extends Exception{

	private String userName;
	
	public UserNotFoundException() {
		super();
	}
	public UserNotFoundException(String userName) {
		super();
		this.userName = userName;
	}



	@Override
	public String toString() {
		return userName + " This User Name does not exist";
	}
	
	@Override
	public String getMessage() {		
		return userName + " This User Name does not exist";
	}
	
}
