package com.webapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Nearby extends IdEntity<Nearby> {
	
	private int lotId;
	private int houseId;
	public int getLotId() {
		return lotId;
	}
	public void setLotId(int lotId) {
		this.lotId = lotId;
	}
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	

}
