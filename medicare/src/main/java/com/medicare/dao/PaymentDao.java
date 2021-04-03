package com.medicare.dao;

import java.util.List;

import com.medicare.dto.PaymentDto;
import com.medicare.dto.UserDto;

public interface PaymentDao {

	public int savePurchasedItems(String purchasedMedicineProductsString,UserDto userDto);
	
	public List<PaymentDto>getPurchasedItemsByUsername(String userid);
}
