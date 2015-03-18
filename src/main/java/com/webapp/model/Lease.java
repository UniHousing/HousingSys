package com.webapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Lease extends IdEntity<Lease>{
	
	private int studentId;
	private int houseId;
	private int roomId;
	private int parkingId;
	private int roomNum;
	private String duration;
	private String enterDate;
	private String leaveDate;
	private double deposit;
	private String payment;
	private double penalty;
	private String inspectDate;
	
	
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
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
	}
	public String getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
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
	public String getInspectDate() {
		return inspectDate;
	}
	public void setInspectDate(String inspectDate) {
		this.inspectDate = inspectDate;
	}
}

