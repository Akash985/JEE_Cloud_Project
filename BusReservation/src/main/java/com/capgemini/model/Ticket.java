package com.capgemini.model;

public class Ticket {
	private static Long ticketNo =2020001L;
	private String passengerName;
	private String busName;
	private String busNo;
	private String busStartpt;
	private String busEndpt;
	private String source;//boarding pt of passenger
	private String destination;//dropping point of passenger
	private double fare;
	private String busDeptTime;
	private String dateOfJourney;
	

	public Ticket(String passengerName, String busName, String busNo, String busStartpt, String busEndpt, String source,
			String destination, double fare, String busDeptTime, String dateOfJourney) {
		ticketNo = ticketNo+1;
		this.passengerName = passengerName;
		this.busName = busName;
		this.busNo = busNo;
		this.busStartpt = busStartpt;
		this.busEndpt = busEndpt;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
		this.busDeptTime = busDeptTime;
		this.dateOfJourney = dateOfJourney;
	}
	
	
	public Long getTicketNo() {
		return ticketNo;
	}

	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getBusTime() {
		return busDeptTime;
	}
	public void setBusTime(String busDeptTime) {
		this.busDeptTime = busDeptTime;
	}


	public String getBusStartpt() {
		return busStartpt;
	}


	public void setBusStartpt(String busStartpt) {
		this.busStartpt = busStartpt;
	}


	public String getBusEndpt() {
		return busEndpt;
	}


	public void setBusEndpt(String busEndpt) {
		this.busEndpt = busEndpt;
	}


	public String getBusDeptTime() {
		return busDeptTime;
	}


	public void setBusDeptTime(String busDeptTime) {
		this.busDeptTime = busDeptTime;
	}


	public String getDateOfJourney() {
		return dateOfJourney;
	}


	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}


	public static void setTicketNo(Long ticketNo) {
		Ticket.ticketNo = ticketNo;
	}



	
}
