package com.capgemini.service;

import com.cagemini.model.Passenger;

public interface BookingService {
	boolean signUp();
	Passenger login(String userName);
	void searchBus(String source,String destination);
	void seatAvailability(String busName[]);
	boolean bookTicket(String busName[],int seatNumber);

}
