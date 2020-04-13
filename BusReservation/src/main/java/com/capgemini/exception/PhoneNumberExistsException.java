package com.capgemini.exception;

public class PhoneNumberExistsException extends Exception {
	
	private long phoneNumber;
	
	public PhoneNumberExistsException() {
		super();
	}



	public PhoneNumberExistsException(long phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}



	@Override
	public String toString() {
		return phoneNumber + " PhoneNumber already exist";
	}
	
	@Override
	public String getMessage() {		
		return phoneNumber + " PhoneNumber already exist";
	}

}
