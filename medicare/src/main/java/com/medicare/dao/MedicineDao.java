package com.medicare.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.medicare.dto.MedicineDto;

public interface MedicineDao {

	public int insert(MedicineDto medicineDto);
	public List<MedicineDto> getAllMedicineDtoList();
	public List<MedicineDto> getMedicineDao(Integer medicineId);
	public int deleteMedicineDto(Integer medicineId);
	public int updateMedicineDtoStatus(Integer medicineId, Integer status);
	public int updateMedicine(MedicineDto medicineDto); 

}
