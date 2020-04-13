package com.capgemini.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capgemini.model.Bus;

public class BusDaoImpl implements BusDao {

	private static List<Bus> busList = new ArrayList<Bus>();

	static {
		String boardingStops1[] = { "Mumbai", "Panvel", "Lonavala" };
		String dropingStops1[] = { "Panvel", "Lonavala", "Pune" };
		Bus mumToPune = new Bus("Mumbai-Pune", "MH04NX1356", "Mumbai", "Pune", boardingStops1, dropingStops1, 20,
				"Dan Bravo");

		String boardingStops2[] = { "Panvel", "Lonavala", "Pune" };
		String dropingStops2[] = { "Lonavala", "Pune", "Satara" };
		Bus panvelToSatara = new Bus("Panvel-Satara", "MH05NX1487", "Panvel", "Satara", boardingStops2, dropingStops2,
				20, "Bhuvan Signh");

		busList.add(mumToPune);
		busList.add(panvelToSatara);

	}
	
	
	@Override
	public boolean createbus(Bus bus) {
		//here validate busDeails method will come
		busList.add(bus);
		return true;
	}
	

	@Override
	public List<Bus> findBus(String source, String destination) {
		List<Bus> sortedBusList = new ArrayList<Bus>();
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

			if (i == 0 && j == 0) {
				// throw neither_of_such_source_or_destination_exists is available
			}
			if (i == 0) {
				// throw no_such_source is available
			}
			if (j == 0) {
				// throw no_such_destination is available
			}
			// throw exception no bus found
		}

		return sortedBusList;
	}

	
	
	
	
	
//addBus method
// createbus(Bus bus) method
//deletebusByBusNumber(String busNumber)
//	updatestmt:- 
//	addbusBoardingStops(String busNumber,String StopName)
//	{
//	search for bus in busList using busnumber
//	once we get the bus
//	then add the busStop in BoardingStops array field of that bus object using addBoardStop in Bus class 
//	
//	}

}
