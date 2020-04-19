package com.capgemini.service;

import com.capgemini.exception.SeatAlreadyOccupiedException;
import com.capgemini.exception.SeatNotAvailableException;
import com.capgemini.model.Bus;

public class SeatArrangementImpl implements SeatArrangement{

	@Override
	public StringBuffer seatAvailability(Bus bus) throws SeatNotAvailableException {
		int count=0;
		StringBuffer seats = new StringBuffer();
		String tempSeats[] = bus.getSeatArrangement();
		for (int i = 0; i < tempSeats.length; i++) {
			if (tempSeats[i] == null) {
				count++;
				seats.append((i+1)+"  ");
				if (((i+1)%10)== 0) {
					seats.append("\n");
				}
				
			}
		}
		
		if(count==0) {
			throw new SeatNotAvailableException(bus.getBusName());
		}
		return seats;
	}

	@Override
	public boolean bookSeat(Bus bus, int seatNo, String pssgnName) throws SeatAlreadyOccupiedException {
		String tempSeats[] = bus.getSeatArrangement();
		boolean result = validateSeat(bus, seatNo);
		if (result == true) {
			tempSeats[seatNo-1] = pssgnName;
			return true;
		}
		return false;
	}

	@Override
	public boolean validateSeat(Bus bus, int seatNo) throws SeatAlreadyOccupiedException {
		String tempSeats[] = bus.getSeatArrangement();
		if (tempSeats[seatNo-1] == null){
			return true;
		}else {
			throw new SeatAlreadyOccupiedException(seatNo);
		}
	}

}