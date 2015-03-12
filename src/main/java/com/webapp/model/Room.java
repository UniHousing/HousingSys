package com.webapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Room extends IdEntity<Room> {

	private String roomNumber;
	private float monthRate;
	private String houseId;
	
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public float getMonthRate() {
		return monthRate;
	}
	public void setMonthRate(float monthRate) {
		this.monthRate = monthRate;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
}

