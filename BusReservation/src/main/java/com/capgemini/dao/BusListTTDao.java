package com.capgemini.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.capgemini.model.Bus;

public class BusListTTDao {

	
	
	private static HashMap<String, List<Bus>> busListAccToTimeTable = new HashMap<String, List<Bus>>();	

	 static HashMap<String, List<Bus>> BusDatabase() {	
		
		SimpleDateFormat SDFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("E");
		Calendar cal = Calendar.getInstance();
//Bus data
		List<Bus> busList ;
		Date offsetDt;
		String offsetDate;
		String offsetDateDay;
		
		
		Bus mumToPune;
		String boardingStops1[] = { "Mumbai", "Panvel", "Lonavala" };
		String dropingStops1[] = { "Panvel", "Lonavala", "Pune" };
		
		Bus panvelToSatara;
		String boardingStops2[] = { "Panvel", "Lonavala", "Pune" };
		String dropingStops2[] = { "Lonavala", "Pune", "Satara" };
		
		Bus panvelToPune;
		String boardingStops3[] = { "Panvel", "Lonavala" };
		String dropingStops3[] = {  "Lonavala", "Pune" };
		
		Bus panvelToKolhapur ;
		String boardingStops4[] = { "Panvel", "Lonavala", "Pune", "Satara" };
		String dropingStops4[] = { "Lonavala", "Pune", "Satara", "Kolhapur"};
		
		
		for (int i = 1; i <= 15; i++) {			
			busList = new ArrayList<Bus>();
			offsetDt = cal.getTime();
			offsetDate = SDFormat.format(offsetDt);//returns date in string -->dd/mm/yyyy
			offsetDateDay = sdf.format(offsetDt);//returns day on that day in string format			
			
			switch (offsetDateDay) {
			case "Mon":
				mumToPune = new Bus("Mumbai-Pune", "MH04NX1356", "Mumbai", "Pune", boardingStops1, dropingStops1, 20,"Dan Bravo","11:30 AM",offsetDate);
				panvelToSatara = new Bus("Panvel-Satara", "MH05NX1487", "Panvel", "Satara", boardingStops2, dropingStops2, 20, "Bhuvan Signh","1:30 PM",offsetDate);
				busList.add(mumToPune);
				busList.add(panvelToSatara);		
				busListAccToTimeTable.put(offsetDate, busList);						
				break;
				
			case "Tue":
				panvelToPune = new Bus("Panvel-Pune", "MH05TX1156", "Panvel", "Pune", boardingStops3, dropingStops3, 20,"Kylo ren","1:00 PM",offsetDate);
				panvelToKolhapur = new Bus("Panvel-Kolhapur", "MH0aNX5662", "Panvel", "Kolhapur", boardingStops4, dropingStops4, 20, "Han Solo","3:30 PM",offsetDate);		
				busList.add(panvelToPune);
				busList.add(panvelToKolhapur);		
				busListAccToTimeTable.put(offsetDate, busList);				
				break;
				
			case "Wed":
				mumToPune = new Bus("Mumbai-Pune", "MH04NX1356", "Mumbai", "Pune", boardingStops1, dropingStops1, 20,"Dan Bravo","11:30 AM",offsetDate);
				panvelToSatara = new Bus("Panvel-Satara", "MH05NX1487", "Panvel", "Satara", boardingStops2, dropingStops2, 20, "Bhuvan Signh","1:30 PM",offsetDate);
				busList.add(mumToPune);
				busList.add(panvelToSatara);		
				busListAccToTimeTable.put(offsetDate, busList);						
				break;
				
			case "Thu":
				panvelToPune = new Bus("Panvel-Pune", "MH05TX1156", "Panvel", "Pune", boardingStops3, dropingStops3, 20,"Kylo ren","1:00 PM",offsetDate);
				panvelToKolhapur = new Bus("Panvel-Kolhapur", "MH0aNX5662", "Panvel", "Kolhapur", boardingStops4, dropingStops4, 20, "Han Solo","3:30 PM",offsetDate);		
				busList.add(panvelToPune);
				busList.add(panvelToKolhapur);		
				busListAccToTimeTable.put(offsetDate, busList);				
				break;
				
			case "Fri":
				mumToPune = new Bus("Mumbai-Pune", "MH04NX1356", "Mumbai", "Pune", boardingStops1, dropingStops1, 20,"Dan Bravo","11:30 AM",offsetDate);
				panvelToSatara = new Bus("Panvel-Satara", "MH05NX1487", "Panvel", "Satara", boardingStops2, dropingStops2, 20, "Bhuvan Signh","1:30 PM",offsetDate);
				busList.add(mumToPune);
				busList.add(panvelToSatara);		
				busListAccToTimeTable.put(offsetDate, busList);						
				break;
				
			case "Sat":
				panvelToPune = new Bus("Panvel-Pune", "MH05TX1156", "Panvel", "Pune", boardingStops3, dropingStops3, 20,"Kylo ren","1:00 PM",offsetDate);
				panvelToKolhapur = new Bus("Panvel-Kolhapur", "MH0aNX5662", "Panvel", "Kolhapur", boardingStops4, dropingStops4, 20, "Han Solo","3:30 PM",offsetDate);		
				busList.add(panvelToPune);
				busList.add(panvelToKolhapur);		
				busListAccToTimeTable.put(offsetDate, busList);				
				break;
				
				
			case "Sun":
				mumToPune = new Bus("Mumbai-Pune", "MH04NX1356", "Mumbai", "Pune", boardingStops1, dropingStops1, 20,"Dan Bravo","11:30 AM",offsetDate);
				panvelToSatara = new Bus("Panvel-Satara", "MH05NX1487", "Panvel", "Satara", boardingStops2, dropingStops2, 20, "Bhuvan Signh","1:30 PM",offsetDate);
				busList.add(mumToPune);
				busList.add(panvelToSatara);		
				busListAccToTimeTable.put(offsetDate, busList);						
				break;
		
			}
			
			cal.add(Calendar.DAY_OF_MONTH, 1);
			
		}	
		
		//this one is for test case
		cal.add(Calendar.DAY_OF_MONTH, 1);
		busList = new ArrayList<Bus>();
		offsetDt = cal.getTime();
		offsetDate = SDFormat.format(offsetDt);//returns date in string -->dd/mm/yyyy
		offsetDateDay = sdf.format(offsetDt);//returns day on that day in string format			
		Bus testBus;
		String bdStops[] = { "st1", "st2", "st3" };
		String dpStops[] = { "st2", "st3", "st4" };
		//String offsetDate = "26/01/2020";// this date is just for test case
		testBus = new Bus("st1-st4", "AB00NX1234", "st1", "st4", bdStops, dpStops, 20, "XYZ",
				"11:30 AM", offsetDate);
		busList.add(testBus);	
		testBus = new Bus("st1-st4", "DC00NX1234", "st1", "st4", bdStops, dpStops, 20, "ABC",
				"11:30 AM", offsetDate);//used in test case for removing
		busList.add(testBus);	
		busListAccToTimeTable.put(offsetDate, busList);	
		//above one is for test case
		
		return busListAccToTimeTable;
	}
	 
	 
}
