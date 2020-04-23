package com.capgemini.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.exception.BusAlreadyExistsInRecordException;
import com.capgemini.exception.BusNotAvailableException;
import com.capgemini.model.Bus;

public class BusDaoImplTest {
	BusDao bdi = null;
	Bus bus1;
	Bus bus2;
	String date;
	
	@Before
	public void setUp() {
		SimpleDateFormat SDFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 16);
		Date dt = cal.getTime();
		date = SDFormat.format(dt);
		
		bdi = new BusDaoImpl();		
		String boardingStops1[] = { "st1", "st2", "st3" };
		String dropingStops1[] = { "st2", "st3", "st4" };
		bus1 = new Bus("st1-st4", "AB00NX1234", "st1", "st4", boardingStops1, dropingStops1, 20, "XYZ",
				"11:30 AM", date);//this existing in database
		bus2 = new Bus("st1-st4", "AB00NX1234", "st1", "st4", boardingStops1, dropingStops1, 20, "XYZ",
				"05:30 PM", date);//same bus after 4hrs

		
	}
	
	@After
	public void tearUp() {
		BusDao bdi = null;
		Bus bus1 = null;
		Bus bus2 = null;
	}

	@Test
	public void testCreateBus() {
		boolean result = false;
		try {
			result = bdi.createBus(bus2, date);			
		} catch (BusAlreadyExistsInRecordException | ParseException e) {
			result = false;
			System.out.println(e.getMessage());
		}
		assertTrue(result);
	}
	
	
	@Test(expected = BusAlreadyExistsInRecordException.class )
	public void testCreateBusBusAlreadyExistsInRecordException() throws BusAlreadyExistsInRecordException {
		try {
			bdi.createBus(bus1, date);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	@Test(expected = ParseException.class )
	public void testCreateBusParseException() throws ParseException {
		date ="27-7-2020";
		
		try {
			bdi.createBus(bus1, date);
		} catch ( BusAlreadyExistsInRecordException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	
	

	@Test
	public void testRemoveBusTrue() {
		boolean result = false;
		String bdStops[] = { "st1", "st2", "st3" };
		String dpStops[] = { "st2", "st3", "st4" };
		Bus testBus = new Bus("st1-st4", "DC00NX1234", "st1", "st4", bdStops, dpStops, 20, "ABC",
				"11:30 AM", date);//used in test case for removing
		
		try {
			result = bdi.removeBus(testBus.getBusNumber(), testBus.getDepartTime(), testBus.getDateOfDept());
			bdi.createBus(testBus, date);//to restore whatever is deleted
		} catch (ParseException | BusAlreadyExistsInRecordException e) {
			System.out.println(e.getMessage());
		}
		assertTrue(result);
	}
	
	@Test
	public void testRemoveBusFalse() {
		boolean result = false;
		boolean result1 = false;
		String bdStops[] = { "st1", "st2", "st3" };
		String dpStops[] = { "st2", "st3", "st4" };
		Bus testBus = new Bus("st1-st4", "MT00NX1234", "st1", "st4", bdStops, dpStops, 20, "ABC",
				"11:30 AM", date);//used in test case for removing according to num
		Bus testBus1 = new Bus("st1-st4", "DC00NX1234", "st1", "st4", bdStops, dpStops, 20, "ABC",
				"12:30 AM", date);//used in test case for removing according to time
		
		try {
			result = bdi.removeBus(testBus.getBusNumber(), testBus.getDepartTime(), testBus.getDateOfDept());
			result1 = bdi.removeBus(testBus1.getBusNumber(), testBus1.getDepartTime(), testBus1.getDateOfDept());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		assertFalse(result);
		assertFalse(result);
	}
	
	@Test(expected = ParseException.class )
	public void testRemoveBusForParseException() throws ParseException {
		date = "27-04-2020";
		bdi.removeBus("st1-st4", "11:30 AM", date);
	}
	
	@Test
	public void testFindBusReturnsSerachedBusList() {
		List<Bus> list = new ArrayList<Bus>();
		List<Bus> list1 = new ArrayList<Bus>();
		list.add(bus1);
		String bdStops[] = { "st1", "st2", "st3" };
		String dpStops[] = { "st2", "st3", "st4" };
		Bus testBus = new Bus("st1-st4", "DC00NX1234", "st1", "st4", bdStops, dpStops, 20, "ABC",
				"11:30 AM", date) ;//used in test case for removing
		list.add(testBus);
		
		
		try {
			list1 = bdi.findBus("st1", "st4", date);			
			assertTrue(list.size()==list1.size() && list.containsAll(list1) );			
		} catch (BusNotAvailableException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	@Test(expected = BusNotAvailableException.class)
	public void testFindBusForBusNotAvailableException() throws BusNotAvailableException {
		
		 bdi.findBus("st1", "st5", date);
	}

}
