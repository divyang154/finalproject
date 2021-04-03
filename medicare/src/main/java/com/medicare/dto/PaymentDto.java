package com.medicare.dto;

import java.util.Date;

public class PaymentDto {

	private String medicineList;
	private Date dateOfPurchase;
	private String userId;
	
	public String getMedicineList() {
		return medicineList;
	}
	public void setMedicineList(String medicineList) {
		this.medicineList = medicineList;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
