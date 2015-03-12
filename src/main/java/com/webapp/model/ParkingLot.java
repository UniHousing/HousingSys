package com.webapp.model;

import org.springframework.stereotype.Component;

@Component
public class ParkingLot extends IdEntity<ParkingLot>{
	
	private int numParkingSpot;
	
	public int getNumParkingLot() {
		return numParkingSpot;
	}

	public void setNumParkingLot(int numParkingLot) {
		this.numParkingSpot = numParkingLot;
	}
}
