package com.capgemini.dao;


import java.util.ArrayList;
import java.util.List;

import com.capgemini.model.Ticket;

public class TicketDaoImpl implements TicketDao {

	private static List<Ticket> ticketList = new ArrayList<Ticket>();

	@Override
	public boolean storeTicketInDatabase(Ticket ticket) {
		//???validate ticket is left-->i.e whether this ticket exists or not
		boolean result = ticketList.add(ticket);
		return result;
	}

	@Override
	public boolean removeTicketFromDatabase(String ticketSrNo) {
		////@ARUN-ST
		//@ARUN-CL
		return false;
	}
	
	/*
	 * add ticket--->boolean storeTicketInDatabase(Ticket ticket);
	 * delete ticket
	 * update ticket information(functions like -->updateTicketDetailsBy
	 * PassengerName or updateTicketDetailsBySrNo)
	 * 
	 * */
	
	
}

