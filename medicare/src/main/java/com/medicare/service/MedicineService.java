package com.medicare.service;

import java.util.List;

import com.medicare.dto.MedicineDto;

public interface MedicineService {

	public void insertMedicine(MedicineDto medicineDto);
	
	public List<MedicineDto> getAllMedicineDto();
	
	public List<MedicineDto> getMedicineDto(Integer medicineId);
	
	public int deleteMedicineDto(Integer medicineId);
	
	public int updateMedicineDtoStatus(Integer medicineId,Integer status);
	
	public int updateMedicine(MedicineDto medicineDto);
	
	public List<MedicineDto> getAllActiveMedicineDto();
	
	public List<MedicineDto> getAllMedicineDtoById(String[] medicineIdList);

}
