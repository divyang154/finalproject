package com.medicare.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medicare.dto.MedicineDto;
import com.medicare.dto.PaymentDto;
import com.medicare.dto.UserDto;
import com.medicare.mapper.MedicineMapper;
import com.medicare.mapper.PaymentMapper;
@Repository(value="paymentDao")
public class PaymentDaoImpl implements PaymentDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	private String insertQuery="insert into `payment` (`medicineIdPurchasedList`,`userId`,`dateOfPurchase`) values (?,?,?)";
    private String selectQuery="select * from `payment` where userid=?";
	
	
	@Override
	public int savePurchasedItems(String purchasedMedicineProductsString,UserDto userDto) {
		// TODO Auto-generated method stub
		int returnedInt=jdbcTemplate.update(insertQuery,new Object[] {purchasedMedicineProductsString,userDto.getUserId(),new Date()});
		return returnedInt;
	}

	@Override
	public List<PaymentDto> getPurchasedItemsByUsername(String userid) {
		// TODO Auto-generated method stub
		List<PaymentDto> paymentDtoList=null;
		paymentDtoList=(ArrayList<PaymentDto>)jdbcTemplate.query(selectQuery,new Object[] {userid},new PaymentMapper());
		return paymentDtoList;
	}

}
