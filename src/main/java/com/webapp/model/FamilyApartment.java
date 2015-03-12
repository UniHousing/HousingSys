package com.webapp.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FamilyApartment extends IdEntity<FamilyApartment> {
	
	private String name;
	private String addr;
	private String tel;
	private int roomCount;
	private int bathCount;
	private Date monthRate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getRoomCount() {
		return roomCount;
	}
	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
	public int getBathCount() {
		return bathCount;
	}
	public void setBathCount(int bathCount) {
		this.bathCount = bathCount;
	}
	public Date getMonthRate() {
		return monthRate;
	}
	public void setMonthRate(Date monthRate) {
		this.monthRate = monthRate;
	}
}

