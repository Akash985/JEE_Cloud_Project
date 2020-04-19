package com.capgemini.dao;

import com.capgemini.model.Passenger;

public interface PassengerDao {
	boolean addPassenger(Passenger pssgn, Long ticketNo);
	boolean deletePassenger(Passenger pssgn, Long ticketNo);

}
