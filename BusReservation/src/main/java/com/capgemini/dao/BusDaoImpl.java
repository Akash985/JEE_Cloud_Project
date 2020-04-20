 package com.capgemini.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.capgemini.exception.BusNotAvailableException;
import com.capgemini.model.Bus;

public class BusDaoImpl implements BusDao {
	//	private HashMap<K, V>
	//hashmap based on weeks
	//key Day of week(eg. mon) and value is buslist
	private static HashMap<String, List<Bus>> busListAccToTimeTable = new HashMap<String, List<Bus>>();	

	static {
		busListAccToTimeTable = BusListTTDao.BusDatabase();	
	}
	
	
	@Override
	public boolean createBus(Bus bus,String date) {		
		List<Bus> busList = new ArrayList<Bus>();
		busList = busListAccToTimeTable.get(date);
		//here validate busDeails method  to check whether already present or not
		busList.add(bus);
		busListAccToTimeTable.put(date, busList);
		return true;
	}
	

	@Override
	public List<Bus> findBus(String source, String destination, String date) throws BusNotAvailableException {
		List<Bus> busList = new ArrayList<Bus>();
		List<Bus> sortedBusList = new ArrayList<Bus>();
		busList = busListAccToTimeTable.get(date);
		Bus bus = null;
		String boardstop[] ;
		String dropstop[] ;
		
		int i = 0, j = 0;

		Iterator<Bus> itr = busList.iterator();
		while (itr.hasNext()) {
			bus = itr.next();
			boardstop = bus.getBoardingStops();
			dropstop = bus.getDroppingStops();
			boolean testSource = false;
			boolean testDestiny = false;

			for (String element : boardstop) {
				if (element.equalsIgnoreCase(source)) {
					i++;
					testSource = true;
					break;
				}
			}

			if (testSource) {
				for (String element : dropstop) {
					if (element.equalsIgnoreCase(destination)) {
						j++;
						testDestiny = true;
						break;
					}
				}
			}

			if (testSource && testDestiny) {
				sortedBusList.add(bus);
			}
			
		}
		

		if (sortedBusList.size() == 0) {			
			throw new BusNotAvailableException(source,destination);
			
			
		}

		return sortedBusList;
	}

	


}
