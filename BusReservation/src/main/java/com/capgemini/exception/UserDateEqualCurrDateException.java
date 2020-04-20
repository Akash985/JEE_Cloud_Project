package com.capgemini.exception;

public class UserDateEqualCurrDateException extends Exception {
	public UserDateEqualCurrDateException(){
		super();
	}
	
	
	@Override
	public String toString() {
		return "Sorry, Cannot book today's Bus!!! ";
	}
	
	@Override
	public String getMessage() {
		return "Sorry, Cannot book today's Bus!!! ";
	}
}
