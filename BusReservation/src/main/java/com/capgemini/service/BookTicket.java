package com.capgemini.service;


import com.capgemini.exception.BookingFailedException;
import com.capgemini.model.Bus;
import com.capgemini.model.Passenger;

public interface BookTicket {
	String bookTicket(String source,String destination, Bus bus, Passenger pssgn, int seatNumber, String journeyDate) throws BookingFailedException;
	String showTicket(String source,String destination, Bus bus, Passenger pssgn, int seatNumber, String journeyDate);
}

