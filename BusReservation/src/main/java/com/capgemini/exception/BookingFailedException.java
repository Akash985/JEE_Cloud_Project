package com.capgemini.exception;

public class BookingFailedException extends Exception{

	public BookingFailedException() {
		super();		
	}
	

	@Override
	public String toString() {
		return "Booking Failed!!!";
	}
	
	@Override
	public String getMessage() {		
		return "Booking Failed!!!";
	}
}
