package com.capgemini.exception;

public class UserDateFallBehindCurrDateException extends Exception {
	String date;

	public UserDateFallBehindCurrDateException() {
		super();
	}

	public UserDateFallBehindCurrDateException(String date) {
		super();
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Date entered("+date+") is already passed!!!";
	}
	
	@Override
	public String getMessage() {
		return "Date entered("+date+") is already passed!!!";
	}
}
