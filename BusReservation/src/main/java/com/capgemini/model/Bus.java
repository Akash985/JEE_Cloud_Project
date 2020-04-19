package com.capgemini.model;

public class Bus {

	private String busName;
	private String busNumber;
	private String startStop;
	private String endStop;
	private String boardingStops[];
	private String droppingStops[];
	private int numberOfSeats;
	private String seatArrangement[];
	private String conductorName;
	private String departTime;

	public Bus(String busName, String busNumber, String startStop, String endStop, String[] boardingStops,
			String[] droppingStops, int numberOfSeats, String conductorName, String deparTtime) {
		this.busName = busName;
		this.busNumber = busNumber;
		this.startStop = startStop;
		this.endStop = endStop;
		this.boardingStops = boardingStops;
		this.droppingStops = droppingStops;
		this.numberOfSeats = numberOfSeats;
		seatArrangement = new String[numberOfSeats];
		this.conductorName = conductorName;
		seatArrangement[1] ="Conductor-"+conductorName;
		this.departTime =deparTtime;
			
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getStartStop() {
		return startStop;
	}

	public void setStartStop(String startStop) {
		this.startStop = startStop;
	}

	public String getEndStop() {
		return endStop;
	}

	public void setEndStop(String endStop) {
		this.endStop = endStop;
	}

	public String[] getBoardingStops() {
		return boardingStops;
	}

	public void setBoardingStops(String[] boardingStops) {
		this.boardingStops = boardingStops;
	}

	public String[] getDroppingStops() {
		return droppingStops;
	}

	public void setDroppingStops(String[] droppingStops) {
		this.droppingStops = droppingStops;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String[] getSeatArrangement() {
		return seatArrangement;
	}

	public void setSeatArrangement(String[] seatArrangement) {
		this.seatArrangement = seatArrangement;
	}

	public String getConductorName() {
		return conductorName;
	}

	public void setConductorName(String conductorName) {
		this.conductorName = conductorName;
	}
	
	public String getDepartTime() {
		return departTime;
	}


	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
		
}
