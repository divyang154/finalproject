package com.medicare.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.dao.MedicineDao;
import com.medicare.dto.MedicineDto;
@Service(value="medicineService")
public class MedicineServiceImpl implements MedicineService{
    @Autowired
	public MedicineDao medicineDao;
	
	@Override
	public void insertMedicine(MedicineDto medicineDto) {
		// TODO Auto-generated method stub
		System.out.println("Inside");
		medicineDao.insert(medicineDto);
	}

	@Override
	public List<MedicineDto> getAllMedicineDto() {
		// TODO Auto-generated method stub
		List<MedicineDto>medicineList= medicineDao.getAllMedicineDtoList();
		return medicineList;
	}

	@Override
	public List<MedicineDto> getMedicineDto(Integer medicineId) {
		// TODO Auto-generated method stub
		List<MedicineDto> medicineDtoList=medicineDao.getMedicineDao(medicineId);
		return medicineDtoList;
	}

	@Override
	public int deleteMedicineDto(Integer medicineId) {
		// TODO Auto-generated method stub
		return medicineDao.deleteMedicineDto(medicineId);
	}

	@Override
	public int updateMedicineDtoStatus(Integer medicineId, Integer status) {
		// TODO Auto-generated method stub
		return medicineDao.updateMedicineDtoStatus(medicineId, status);
	}

	@Override
	public int updateMedicine(MedicineDto medicineDto) {
		// TODO Auto-generated method stub
		int returnedInt=medicineDao.updateMedicine(medicineDto);
		return returnedInt;
	}

	@Override
	public List<MedicineDto> getAllActiveMedicineDto() {
		// TODO Auto-generated method stub
		List<MedicineDto>medicineList= medicineDao.getAllMedicineDtoList().stream().filter(medicine -> medicine.getStatus()==0).collect(Collectors.toList());
	    return medicineList;
	}

}
