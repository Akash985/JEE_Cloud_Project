package com.capgemini.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.capgemini.exception.BusAlreadyExistsInRecordException;
import com.capgemini.exception.BusNotAvailableException;
import com.capgemini.model.Bus;

public class BusDaoImpl implements BusDao {
	// private HashMap<K, V>
	// hashmap based on weeks
	// key Day of week(eg. mon) and value is buslist
	private static HashMap<String, List<Bus>> busListAccToTimeTable = new HashMap<String, List<Bus>>();

	static {
		busListAccToTimeTable = BusListTTDao.BusDatabase();
	}

	@Override
	public boolean createBus(Bus bus, String date) throws BusAlreadyExistsInRecordException, ParseException {
		//if date is like 2/4/2020 --->then it should be converted to 02/04/2020
		SimpleDateFormat SDFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = SDFormat.parse(date);
		date = SDFormat.format(dt);
		
		boolean result = false;
		List<Bus> busList = new ArrayList<Bus>();
		busList = busListAccToTimeTable.get(date);
		boolean res = containsBusWithinTimerange(bus, busList);//retruns true if it contains the bus
		// here validate busDeails method to check whether already present or not
		if (!res) {
			busList.add(bus);
			busListAccToTimeTable.put(date, busList);
			result = true;
		} else {
			result = false;
			throw new BusAlreadyExistsInRecordException();
		}
		return result;
	}

	@Override
	public boolean removeBus(String busNum, String time, String date) throws ParseException {
		//if date is like 2/4/2020 --->then it should be converted to 02/04/2020
		SimpleDateFormat SDFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = SDFormat.parse(date);
		date = SDFormat.format(dt);		
		
		Bus tempBus;
		boolean result = false;
		List<Bus> busList = new ArrayList<Bus>();
		busList = busListAccToTimeTable.get(date);
		Iterator<Bus> itr = busList.iterator();
		while (itr.hasNext()) {
			tempBus = itr.next();
			if (tempBus.getBusNumber().equals(busNum)) {
				if (tempBus.getDepartTime().equals(time)) {
					busList.remove(tempBus);
					result = true; 
					break;
				}
			}
		}
		return result;
	}

	@Override
	public List<Bus> findBus(String source, String destination, String date) throws BusNotAvailableException {
		List<Bus> busList = new ArrayList<Bus>();
		List<Bus> sortedBusList = new ArrayList<Bus>();
		busList = busListAccToTimeTable.get(date);
		Bus bus = null;
		String boardstop[];
		String dropstop[];

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
			throw new BusNotAvailableException(source, destination);

		}

		return sortedBusList;
	}

	@Override
	public boolean containsBusWithinTimerange(Bus bus, List<Bus> busList) throws ParseException {
		SimpleDateFormat SD1Format = new SimpleDateFormat("hh:mm aa");
		Calendar cal = Calendar.getInstance();
		Date tempBusdd;
		Date tempBusddAfter;
		Date tempBusddBefore;

		Date busdd = SD1Format.parse(bus.getDepartTime());
		boolean result = false;
		Bus tempBus = null;
		Iterator<Bus> itr = busList.iterator();

		while (itr.hasNext()) {
			tempBus = itr.next();
			if (bus.getBusNumber().equals(tempBus.getBusNumber())) {

				tempBusdd = SD1Format.parse(tempBus.getDepartTime());

				cal.setTime(tempBusdd);
				cal.add(Calendar.HOUR_OF_DAY, 4);
				tempBusddAfter = cal.getTime();

				cal.setTime(tempBusdd);
				cal.add(Calendar.HOUR_OF_DAY, -4);
				tempBusddBefore = cal.getTime();

				if (busdd.before(tempBusddAfter) && busdd.after(tempBusddBefore)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

}
