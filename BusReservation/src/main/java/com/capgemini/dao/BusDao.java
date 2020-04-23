package com.capgemini.dao;

import java.text.ParseException;
import java.util.List;

import com.capgemini.exception.BusAlreadyExistsInRecordException;
import com.capgemini.exception.BusNotAvailableException;
import com.capgemini.model.Bus;

public interface BusDao {
	
	List<Bus> findBus(String source, String destination, String date) throws BusNotAvailableException;	
	boolean createBus(Bus bus, String date) throws BusAlreadyExistsInRecordException, ParseException;
	boolean removeBus(String busNum, String time, String date) throws ParseException;
	boolean containsBusWithinTimerange(Bus bus,List<Bus> busList) throws ParseException;

}
