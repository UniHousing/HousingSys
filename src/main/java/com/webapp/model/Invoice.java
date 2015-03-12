package com.webapp.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
@Document

public class Invoice extends IdEntity<Invoice>{
	
	private String leaseId;
	private Date payDate;
	private String status;
	private float penalty;
	private float damageCharge;
	private float lateFee;
	private float total;
	
	public String getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(String leaseId) {
		this.leaseId = leaseId;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getPenalty() {
		return penalty;
	}
	public void setPenalty(float penalty) {
		this.penalty = penalty;
	}
	public float getDamageCharge() {
		return damageCharge;
	}
	public void setDamageCharge(float damageCharge) {
		this.damageCharge = damageCharge;
	}
	public float getLateFee() {
		return lateFee;
	}
	public void setLateFee(float lateFee) {
		this.lateFee = lateFee;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
}