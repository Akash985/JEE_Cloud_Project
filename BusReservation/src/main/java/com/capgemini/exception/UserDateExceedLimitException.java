package com.capgemini.exception;

public class UserDateExceedLimitException extends Exception{
	
	private String date;

	public UserDateExceedLimitException() {
		super();
	}

	public UserDateExceedLimitException(String date) {
		super();
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Booking is available upto "+ date+ " only!!!";
	}
	
	@Override
	public String getMessage() {
		return "Booking is available upto "+ date+ " only!!!";
	}

}
