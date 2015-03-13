package com.webapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Nearby extends IdEntity<Nearby> {
	
	private String lotId;
	private String houseId;
	
	public String getLotId() {
		return lotId;
	}
	public void setLotId(String lotId) {
		this.lotId = lotId;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
}
