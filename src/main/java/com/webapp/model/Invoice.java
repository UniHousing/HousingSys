package com.webapp.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
@Document

public class Invoice extends IdEntity<Invoice>{
	
	private String leaseId;
	private String payDate;
	private String payMethod;
	private String status;
	private double penalty;
	private double damageCharge;
	private double lateFee;
	private double total;
	
	public String getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(String leaseId) {
		this.leaseId = leaseId;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String dob) {
		this.payDate = dob;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPenalty() {
		return penalty;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	public double getDamageCharge() {
		return damageCharge;
	}
	public void setDamageCharge(double d) {
		this.damageCharge = d;
	}
	public double getLateFee() {
		return lateFee;
	}
	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
}