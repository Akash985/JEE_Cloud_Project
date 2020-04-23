package com.capgemini.dao;

import java.util.HashMap;

import com.capgemini.model.Passenger;

public class PassengerDaoImpl implements PassengerDao{
	
	private static HashMap<Long, Passenger> passengerList = new HashMap<Long, Passenger>();

	@Override
	public boolean addPassenger(Passenger pssgn, Long ticketNo) {
		passengerList.put(ticketNo, pssgn);		
		return true;
	}

	@Override
	public boolean deletePassenger(Passenger pssgn, Long ticketNo) {
		return passengerList.remove(ticketNo, pssgn);
	}	

}
