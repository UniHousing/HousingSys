package com.webapp.model;

public class ParkingSpot {
	private String id;
	private String lot_id;
	private String classification;
	private float fee;
	private String availiablity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLot_id() {
		return lot_id;
	}
	public void setLot_id(String lot_id) {
		this.lot_id = lot_id;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public String getAvailiablity() {
		return availiablity;
	}
	public void setAvailiablity(String availiablity) {
		this.availiablity = availiablity;
	}
	
}
