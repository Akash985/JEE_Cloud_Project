package com.capgemini.exception;
//This Sample template 
public class FullNameExistsException extends Exception {
	private String fullName;
	
	public FullNameExistsException() {
		super();
	}



	public FullNameExistsException(String fullName) {
		super();
		this.fullName = fullName;
	}



	@Override
	public String toString() {
		return fullName + " This Name already exist";
	}
	
	@Override
	public String getMessage() {		
		return fullName + " This Name already exist";
	}	
	
}
