package com.medicare.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medicare.dto.MedicineDto;
import com.medicare.mapper.MedicineMapper;
@Repository(value="medicineDao")
public class MedicineDaoImpl implements MedicineDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String insertQuery="insert into `medicine` (`medicineName`,`medicineDescription`,`medicinePrice`,`medicineSeller`,`status`) values (?,?,?,?,?)";
	private String selectQuery="select * from `medicine`";
	private String getQuery="select * from `medicine` where medicineId=?";
	private String deleteQuery="delete from `medicine` where medicineId=? ";
	private String updateStatusQuery="update `medicine` set status=? where medicineId=? ";
	private String updateQuery="update `medicine` set medicineName=?,medicineDescription=?,medicinePrice=?,medicineSeller=?,status=? where medicineId=? ";
	
	@Override
	public int insert(MedicineDto medicineDto) {
		// TODO Auto-generated method stub
		System.out.println("console medicine" + medicineDto);
		int returnedInt=jdbcTemplate.update(insertQuery,new Object[] {medicineDto.getMedicineName(),medicineDto.getMedicineDescription(),medicineDto.getMedicinePrice(),medicineDto.getMedicineSeller()});
		return returnedInt;
	}


	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<MedicineDto> getAllMedicineDtoList() {
		// TODO Auto-generated method stub
		List<MedicineDto> medicineDtoList=null;
		Object[] parameters = new Object[] {};
		medicineDtoList=(ArrayList<MedicineDto>)jdbcTemplate.query(selectQuery, parameters,new MedicineMapper());
		return medicineDtoList;
	}


	@Override
	public List<MedicineDto> getMedicineDao(Integer medicineId) {
		// TODO Auto-generated method stub
		List<MedicineDto> medicineDtoList=(ArrayList<MedicineDto>)jdbcTemplate.query(getQuery, new Object[] {medicineId},new MedicineMapper());
		return medicineDtoList;
	}


	@Override
	public int deleteMedicineDto(Integer medicineId) {
		// TODO Auto-generated method stub
		int returnedInt=jdbcTemplate.update(deleteQuery,new Object[] {medicineId});
		return returnedInt;
	}


	@Override
	public int updateMedicineDtoStatus(Integer medicineId, Integer status) {
		// TODO Auto-generated method stub
		int returnedInt=jdbcTemplate.update(updateStatusQuery,new Object[] {medicineId,status});
		return returnedInt;
	}


	@Override
	public int updateMedicine(MedicineDto medicineDto) {
		// TODO Auto-generated method stub
		int returnedInt=jdbcTemplate.update(updateQuery,new Object[] {medicineDto.getMedicineName(),medicineDto.getMedicineDescription(),medicineDto.getMedicinePrice(),medicineDto.getMedicineSeller(),medicineDto.getStatus(),medicineDto.getMedicineId()});
		return returnedInt;
	}
	
	

}
