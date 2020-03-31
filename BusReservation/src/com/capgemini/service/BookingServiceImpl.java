package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.model.Passenger;

public class BookingServiceImpl implements BookingService {

	private static List<Passenger> pssgnList = new ArrayList<Passenger>();
	private static String bus1[] = new String[20];//bus1-->is name of bus which is having 20seats
	private static String bus2[] = new String[20];
	private static String bus3[] = new String[20];
	private static String bus4[] = new String[20];
	@Override
	public boolean signUp() {

		return false;
	}

	@Override
	public Passenger login(String userName) {

		return null;
	}

	@Override
	public void searchBus(String source, String destination) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seatAvailability(String[] busName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean bookTicket(String[] busName, int seatNumber) {
		// TODO Auto-generated method stub
		return false;
	}

}
