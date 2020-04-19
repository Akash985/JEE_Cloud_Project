package com.capgemini.service;

import com.capgemini.exception.SeatAlreadyOccupiedException;
import com.capgemini.exception.SeatNotAvailableException;
import com.capgemini.model.Bus;

public interface SeatArrangement {
	StringBuffer seatAvailability(Bus bus) throws SeatNotAvailableException ;
	boolean bookSeat(Bus bus, int seatNo, String pssgnName);
	boolean validateSeat(Bus bus, int seatNo) throws SeatAlreadyOccupiedException;

}
