package com.capgemini.exception;

public class SourceAndDestinationAreEqualException extends Exception {
	
	public SourceAndDestinationAreEqualException(){
		super();	
	}
	
	@Override
	public String toString() {
		return "Source and Destination should not be equal!!!! Try again...";
	}
	
	@Override
	public String getMessage() {
		return "Source and Destination should not equal!!!! Try again...";
	}	
	

}
