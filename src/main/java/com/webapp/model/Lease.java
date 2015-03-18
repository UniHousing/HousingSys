package com.webapp.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Lease extends IdEntity<Lease>{
	
	private int studentId;
	private int houseId;
	private int roomId;
	private int parkingId;
	private String roomNum;
	private String duration;
	private Date enterDate;
	private Date leaveDate;
	private double deposit;
	private String payment;
	private double penalty;
	private Date inspectDate;
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getParkingId() {
		return parkingId;
	}
	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}

	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public void setLeaveDate(Date date) {
		this.leaveDate = date;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double d) {
		this.deposit = d;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public double getPenalty() {
		return penalty;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public Date getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	public Date getInspectDate() {
		return inspectDate;
	}
	public void setInspectDate(Date inspectDate) {
		this.inspectDate = inspectDate;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}

}

