package com.medicare.dto;

public class MedicineDto implements Comparable{
	private int medicineId;
	private String medicineName;
	private Double medicinePrice;
	private String medicineSeller;
	private String medicineDescription;
	private String formAct;
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	
	public Double getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(Double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
	public String getMedicineSeller() {
		return medicineSeller;
	}
	public void setMedicineSeller(String medicineSeller) {
		this.medicineSeller = medicineSeller;
	}
	public String getMedicineDescription() {
		return medicineDescription;
	}
	public void setMedicineDescription(String medicineDescription) {
		this.medicineDescription = medicineDescription;
	}
	public String getFormAct() {
		return formAct;
	}
	public void setFormAct(String formAct) {
		this.formAct = formAct;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		MedicineDto medicineDto=(MedicineDto)o;
		return this.medicinePrice.compareTo(medicineDto.getMedicinePrice());
	}
}
