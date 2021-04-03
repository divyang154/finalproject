package com.medicare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medicare.dto.PaymentDto;
import com.medicare.dto.UserDto;

public class PaymentMapper implements RowMapper<PaymentDto>{

	@Override
	public PaymentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		PaymentDto paymentDto=new PaymentDto();
		paymentDto.setDateOfPurchase(rs.getDate("dateOfPurchase"));
		paymentDto.setMedicineList(rs.getString("medicineIdPurchasedList"));
		paymentDto.setUserId(rs.getString("userId"));
		return paymentDto;
	}

}
