package com.capgemini.service;

import com.capgemini.dao.FareDao;
import com.capgemini.dao.FareDaoImpl;
import com.capgemini.dao.PassengerDao;
import com.capgemini.dao.PassengerDaoImpl;
import com.capgemini.dao.TicketDao;
import com.capgemini.dao.TicketDaoImpl;
import com.capgemini.exception.BookingFailedException;
import com.capgemini.exception.SeatAlreadyOccupiedException;
import com.capgemini.model.Bus;
import com.capgemini.model.Passenger;
import com.capgemini.model.Ticket;

public class BookTicketImpl implements BookTicket {
	private static TicketDao ticketDao = new TicketDaoImpl();
	private static FareDao fareDao= new FareDaoImpl();
	private static SeatArrangement seatarrgn = new SeatArrangementImpl();
	private static PassengerDao pssgnDao = new PassengerDaoImpl();
	
	@Override
	public String bookTicket(String source, String destination, Bus bus, Passenger pssgn, int seatNumber,String journeyDate) throws BookingFailedException{
		boolean seatRes = false;
		boolean ticketRes = false;
		Ticket ticket = null;
		//calculate fare
		double fare = fareDao.calculateFare(source, destination, bus, pssgn);
		seatRes =seatarrgn.bookSeat(bus, seatNumber, pssgn.getPassengerName());
		if(seatRes) {
		ticket = new Ticket(pssgn.getPassengerName(), bus.getBusName(), bus.getBusNumber(), bus.getStartStop(), bus.getEndStop(), source, destination, fare,bus.getDepartTime(), journeyDate);
		ticketRes = ticketDao.storeTicketInDatabase(ticket);
		}
		if(ticketRes) {
			pssgnDao.addPassenger(pssgn, ticket.getTicketNo());
			return "Your ticket is confirmed and it as follows:\n"
						+"Ticket No : "+ticket.getTicketNo()+"\n"
						+showTicket(source, destination, bus, pssgn, seatNumber, journeyDate);
		}
		else {
			throw new BookingFailedException();
		}
		
	}

	@Override
	public String showTicket(String source, String destination, Bus bus, Passenger pssgn, int seatNumber, String journeyDate) {
		//calculate fare
		double fare = fareDao.calculateFare(source, destination, bus, pssgn);
		return "Bus Name : "+bus.getBusName()+"\n"
					+"Bus no. :"+bus.getBusNumber()+"\n"
					+"Bus starts from : "+bus.getStartStop()+"\n"
					+"Bus final destination : "+bus.getEndStop()+"\n"
					+"Date of Journey : "+journeyDate+"\n"
					+"Departure time from Starting point : "+bus.getDepartTime()+"\n"
					+"Your : \n"
					+"Boarding point : "+source+"\n"
					+"Dropping point : "+destination+"\n"
					+"Seat Number : "+seatNumber+"\n"
					+"Passenger details : \n"
					+"Name : "+pssgn.getPassengerName()+"\n"
					+"Gender : "+pssgn.getGender()+"\n"
					+"Age : "+pssgn.getAge()+"\n"
					+"Fare : "+fare+"\n";
					
	}


	//functions suchs 
	//showTicketDetailsByTicketNo(Long Ticket)
	//cancelTicketByTicketNo(Long TicketNo)

}
