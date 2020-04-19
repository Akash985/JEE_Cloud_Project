package com.capgemini.exception;

public class SeatAlreadyOccupiedException extends Exception{
	private int seatNo;
	public SeatAlreadyOccupiedException() {
		super();
		
	}
	public SeatAlreadyOccupiedException(int seatNo) {
		super();
		this.seatNo = seatNo;
	}
	
	
	@Override
	public String toString() {
		return "Seat number - "+seatNo+" is already Occupied";
	}

	@Override
	public String getMessage() {
		return "Seat number - "+seatNo+" is already Occupied";
	}
	

}
