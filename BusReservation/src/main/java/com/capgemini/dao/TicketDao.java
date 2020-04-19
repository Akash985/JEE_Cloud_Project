package com.capgemini.dao;

import com.capgemini.model.Ticket;

public interface TicketDao {

	//add ticket--->boolean storeTicketInDatabase(Ticket ticket);
	//delete ticket
	//update ticket information
		
		boolean storeTicketInDatabase(Ticket ticket);
		boolean removeTicketFromDatabase(String ticketSrNo);
}
