package com.capgemini.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.model.Bus;

public interface BusDao {
	
	List<Bus> findBus(String source, String destination);	
	boolean createbus(Bus bus);
	


}
