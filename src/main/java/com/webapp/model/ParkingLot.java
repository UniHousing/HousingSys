package com.webapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ParkingLot extends IdEntity<ParkingLot>{
	
	private int numParkingSpot;
	
	public int getNumParkingLot() {
		return numParkingSpot;
	}

	public void setNumParkingLot(int numParkingLot) {
		this.numParkingSpot = numParkingLot;
	}
}
