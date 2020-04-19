package com.capgemini.dao;

import java.util.List;

import com.capgemini.exception.BusNotAvailableException;
import com.capgemini.model.Bus;

public interface BusDao {	
	List<Bus> findBus(String source, String destination, String day) throws BusNotAvailableException;	
	boolean createBus(Bus bus,String day) ;
}
