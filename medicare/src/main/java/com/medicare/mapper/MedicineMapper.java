package com.medicare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.medicare.dto.MedicineDto;
public class MedicineMapper implements RowMapper<MedicineDto>{

	@Override
	public MedicineDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		MedicineDto medicineDto=new MedicineDto();
		medicineDto.setMedicineId(rs.getInt("medicineId"));
		medicineDto.setMedicineDescription(rs.getString("medicineDescription"));
		medicineDto.setMedicineName(rs.getString("medicineName"));
		medicineDto.setMedicinePrice(rs.getDouble("medicinePrice"));
		medicineDto.setMedicineSeller(rs.getString("medicineSeller"));
		medicineDto.setStatus(rs.getInt("status"));
		return medicineDto;
	}

}
