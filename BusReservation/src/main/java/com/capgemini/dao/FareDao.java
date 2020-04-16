package com.capgemini.dao;

import com.capgemini.model.Bus;
import com.capgemini.model.Passenger;

public interface FareDao {
	double calculateFare(String source,String destination,Bus bus,Passenger pssgn);

}
