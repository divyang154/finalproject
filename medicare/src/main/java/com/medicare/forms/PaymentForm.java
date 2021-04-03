package com.medicare.forms;

import java.util.Date;
import java.util.List;

import com.medicare.dto.MedicineDto;
import com.medicare.dto.PaymentDto;

public class PaymentForm {
	private List<PaymentDto>paymentDtoList;
	private String medicineList;
	private Date dateOfPurchase;
	private String userId;
	public String getFormAct() {
		return formAct;
	}
	public void setFormAct(String formAct) {
		this.formAct = formAct;
	}
	private String formAct;

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
	public List<PaymentDto> getPaymentDtoList() {
		return paymentDtoList;
	}
	public void setPaymentDtoList(List<PaymentDto> paymentDtoList) {
		this.paymentDtoList = paymentDtoList;
	}
}
