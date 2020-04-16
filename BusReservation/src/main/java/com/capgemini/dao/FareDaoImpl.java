package com.capgemini.dao;

import java.util.HashMap;

import com.capgemini.model.Bus;
import com.capgemini.model.Passenger;

public class FareDaoImpl implements FareDao{
	private static HashMap<String, Double> fareList = new HashMap<String, Double>();
	// here Key-->string is SourceTodestination value and Value-->double is distance
	static {
//		fareList.put(key, value); if key is already existing in farelist and
//		we are trying to add same key then it will replace the old value of value_place with new ones

	fareList.put("mumbai-panvel", 50.0);
	fareList.put("panvel-mumbai", 50.0);
	fareList.put("mumbai-lonavala", 110.0);
	fareList.put("lonavala-mumbai", 110.0);
	fareList.put("mumbai-pune", 160.0);
	fareList.put("pune-mumbai", 160.0);
	fareList.put("mumbai-satara", 210.0);
	fareList.put("satara-mumbai", 210.0);

}
	
	
	
	@Override
	public double calculateFare(String source, String destination, Bus bus, Passenger pssgn) {
		String sourceToDestination = source+"-"+destination;
		double distance = fareList.get(sourceToDestination);//in km
		
		/*
		 * Rs1.5 for 1km for normal bus---> right now we are using this one for every bus
		 * but we can extend this by categorizing bus into ac, nonac, semi luxury,sleeper,nonsleeper,superfast(here we will use Bus object bus)
		 * and accordingly we decide fare/km in rs
		 * */
		double fare = 1.5*distance;
		
		if(pssgn.getAge()>11 && pssgn.getAge()<60) {
			return fare;
		}else {
			return fare/2;
		}			
	}

}
