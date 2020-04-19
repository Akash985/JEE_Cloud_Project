package com.capgemini.service;

import java.util.List;

import com.capgemini.dao.BusDao;
import com.capgemini.dao.BusDaoImpl;
import com.capgemini.exception.BusNotAvailableException;
import com.capgemini.exception.SourceAndDestinationAreEqualException;
import com.capgemini.model.Bus;

public class SearchBusImpl implements SearchBus {
	BusDao busDao = new BusDaoImpl();
	@Override
	public List<Bus> showAvailableBuses(String source, String destination, String day) throws BusNotAvailableException, SourceAndDestinationAreEqualException {
		if(source.equalsIgnoreCase(destination)) {
			throw new SourceAndDestinationAreEqualException();
			
		}else {
			return busDao.findBus(source, destination, day);			
		}
		
		
	}

	
	
}
