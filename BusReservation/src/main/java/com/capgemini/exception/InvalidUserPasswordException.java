package com.capgemini.exception;

public class InvalidUserPasswordException extends Exception{
	
	public InvalidUserPasswordException() {
		super();
	}


	@Override
	public String toString() {
		return "Password is Invalid!!! try again...";
	}
	
	@Override
	public String getMessage() {
		return "Password is Invalid!!! try again...";
	}	
	
	
	
}
