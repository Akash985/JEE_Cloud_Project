package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.dao.BusDao;
import com.capgemini.dao.BusDaoImpl;
import com.capgemini.model.Bus;

public class SearchBusImpl implements SearchBus {
	BusDao busDao = new BusDaoImpl();
	@Override
	public List<Bus> showAvailableBuses(String source, String destination) {
		if(source.equalsIgnoreCase(destination)) {
			//throw source and destiantion equla exception
			return null;
			
		}else {
			return busDao.findBus(source, destination);			
		}
		
		
	}

	
	
}
