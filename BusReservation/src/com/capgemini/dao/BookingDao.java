package com.capgemini.dao;

import java.util.List;
import java.util.Map;

import com.capgemini.model.Passenger;

public interface BookingDao {
	List<Passenger> retrievePassgnList();
	Map<String, String[][]> retrieveBusList();	
}