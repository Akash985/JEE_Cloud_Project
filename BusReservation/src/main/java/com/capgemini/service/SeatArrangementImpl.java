package com.capgemini.service;

import com.capgemini.model.Bus;

public class SeatArrangementImpl implements SeatArrangement{

	@Override
	public StringBuffer seatAvailability(Bus bus) {
		StringBuffer seats = new StringBuffer();
		String tempBus[] = bus.getSeatArrangement();
		for (int i = 0; i < tempBus.length; i++) {
			if (tempBus[i] == null) {
				seats.append((i+1)+"  ");
				if (((i+1)%10)== 0) {
					seats.append("\n");
				}
				
			}
		}
		return seats;
	}

}
