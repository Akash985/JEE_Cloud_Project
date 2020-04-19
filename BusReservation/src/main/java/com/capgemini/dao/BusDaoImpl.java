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

	private static List<Bus> monBusList = new ArrayList<Bus>();
	private static List<Bus> tueBusList = new ArrayList<Bus>();
	private static List<Bus> wedBusList = new ArrayList<Bus>();
	private static List<Bus> thuBusList = new ArrayList<Bus>();
	private static List<Bus> friBusList = new ArrayList<Bus>();
	private static List<Bus> satBusList = new ArrayList<Bus>();
	private static List<Bus> sunBusList = new ArrayList<Bus>();

	static {
		//for monday
		String boardingStops1[] = { "Mumbai", "Panvel", "Lonavala" };
		String dropingStops1[] = { "Panvel", "Lonavala", "Pune" };
		Bus mumToPune = new Bus("Mumbai-Pune", "MH04NX1356", "Mumbai", "Pune", boardingStops1, dropingStops1, 20,"Dan Bravo","11:30 AM");

		String boardingStops2[] = { "Panvel", "Lonavala", "Pune" };
		String dropingStops2[] = { "Lonavala", "Pune", "Satara" };
		Bus panvelToSatara = new Bus("Panvel-Satara", "MH05NX1487", "Panvel", "Satara", boardingStops2, dropingStops2, 20, "Bhuvan Signh","1:30 PM");

		monBusList.add(mumToPune);
		monBusList.add(panvelToSatara);		
		busListAccToTimeTable.put("Mon", monBusList);
		
		
		//for tuesday
		String boardingStops3[] = { "Panvel", "Lonavala" };
		String dropingStops3[] = {  "Lonavala", "Pune" };
		Bus panvelToPune = new Bus("Panvel-Pune", "MH05TX1156", "Panvel", "Pune", boardingStops3, dropingStops3, 20,"Kylo ren","1:00 PM");

		String boardingStops4[] = { "Panvel", "Lonavala", "Pune", "Satara" };
		String dropingStops4[] = { "Lonavala", "Pune", "Satara", "Kolhapur"};
		Bus panvelToKolhapur = new Bus("Panvel-Kolhapur", "MH0aNX5662", "Panvel", "Kolhapur", boardingStops4, dropingStops4, 20, "Han Solo","3:30 PM");

		tueBusList.add(panvelToPune);
		tueBusList.add(panvelToKolhapur);		
		busListAccToTimeTable.put("Tue", tueBusList);
		
		//for Wednesday
		wedBusList.add(mumToPune);
		wedBusList.add(panvelToSatara);		
		busListAccToTimeTable.put("Wed", wedBusList);
		
		//for Thursday
		thuBusList.add(panvelToPune);
		thuBusList.add(panvelToKolhapur);		
		busListAccToTimeTable.put("Thu", thuBusList);
		
		//for Friday
		friBusList.add(mumToPune);
		friBusList.add(panvelToSatara);		
		busListAccToTimeTable.put("Fri", friBusList);
		
		//for Saturday
		satBusList.add(panvelToPune);
		satBusList.add(panvelToKolhapur);		
		busListAccToTimeTable.put("Sat", satBusList);
		
		//for Sunday
		sunBusList.add(mumToPune);
		sunBusList.add(panvelToSatara);		
		busListAccToTimeTable.put("Sun", sunBusList);
		
		

	}
	
	
	@Override
	public boolean createBus(Bus bus,String day) {		
		List<Bus> busList = new ArrayList<Bus>();
		busList = busListAccToTimeTable.get(day);
		//here validate busDeails method  to check whether already present or not
		busList.add(bus);
		busListAccToTimeTable.put(day, busList);
		return true;
	}
	

	@Override
	public List<Bus> findBus(String source, String destination, String day) throws BusNotAvailableException {
		List<Bus> busList = new ArrayList<Bus>();
		List<Bus> sortedBusList = new ArrayList<Bus>();
		busList = busListAccToTimeTable.get(day);
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
