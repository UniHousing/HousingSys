package com.webapp.model;

import java.util.Date;


public class Ticket extends IdEntity<Ticket> {

	private String type; 
	private int studentId;
	private Date date;
	private String location;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
