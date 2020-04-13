package com.capgemini.service;

import com.capgemini.model.Bus;
import com.capgemini.model.Passenger;

public interface BookTicket {
	String bookTicket(Bus bus, Passenger pssgn, int seatNumber);
	String showTicket(Bus bus, Passenger pssgn, int seatNumber);

}
