package com.capgemini.exception;

public class BusAlreadyExistsInRecordException extends Exception{
	
	public BusAlreadyExistsInRecordException(){
		super();
	}
	
	@Override
	public String toString() {
		return "Same Bus already exist in Record for same time!!!";
	}
	
	@Override
	public String getMessage() {
		return "Same Bus already exist in Record for same time!!!";
		}
}
