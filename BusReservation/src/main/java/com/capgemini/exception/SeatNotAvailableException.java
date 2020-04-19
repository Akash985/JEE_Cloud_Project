package com.capgemini.exception;

public class SeatNotAvailableException extends Exception{
	String busName;

	public SeatNotAvailableException() {
		super();
	}

	public SeatNotAvailableException(String busName) {
		super();
		this.busName = busName;
	}
	
	
	@Override
	public String toString() {
		return "Seats are not available for this bus - "+busName;
	}
	
	@Override
	public String getMessage() {		
		return "Seats are not available for this bus - "+busName;
	}
	
}
