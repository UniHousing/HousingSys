package com.webapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ParkingLot extends IdEntity<ParkingLot>{
	
	private int numParkingLot;
	
	public int getNumParkingLot() {
		return numParkingLot;
	}

	public void setNumParkingLot(int numParkingLot) {
		this.numParkingLot = numParkingLot;
	}
}
