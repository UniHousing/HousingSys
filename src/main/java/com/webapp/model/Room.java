package com.webapp.model;

import org.springframework.stereotype.Component;

@Component
public class Room extends IdEntity<Room> {

	private String roomNumber;
	private float monthRate;
	private int houseId;
	
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
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	
}

