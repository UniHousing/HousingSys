package com.webapp.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TerminReq extends IdEntity<TerminReq> {

	private String leaseId;
	private String reason;
	private String status;
	private Date inspectionDate;
	private float extraFee;
	
	public String getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(String leaseId) {
		this.leaseId = leaseId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getInspectionDate() {
		return inspectionDate;
	}
	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}
	public float getExtraFee() {
		return extraFee;
	}
	public void setExtraFee(float extraFee) {
		this.extraFee = extraFee;
	}
}