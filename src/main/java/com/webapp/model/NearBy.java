package com.webapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NearBy extends IdEntity<NearBy> {
	
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
