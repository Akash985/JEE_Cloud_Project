package com.capgemini.exception;

import java.io.ObjectInputStream.GetField;

public class BusNotAvailableException extends Exception{
	
	String source;
	String destination;
	
	public BusNotAvailableException() {
		super();
	}
	
	public BusNotAvailableException(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}

	
	@Override
	public String toString() {
		return "Bus not available from "+source+"-"+destination+" on this day";
	}
	
	@Override
	public String getMessage() {		
		return"Bus not available from "+source+"-"+destination+" on this day";
	}
	

}
