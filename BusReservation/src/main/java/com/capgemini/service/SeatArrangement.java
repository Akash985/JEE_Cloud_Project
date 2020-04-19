package com.capgemini.service;

import com.capgemini.exception.SeatNotAvailableException;
import com.capgemini.model.Bus;

public interface SeatArrangement {
	StringBuffer seatAvailability(Bus bus) throws SeatNotAvailableException ;

}
