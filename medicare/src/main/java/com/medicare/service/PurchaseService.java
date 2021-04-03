package com.medicare.service;

import java.util.List;

import com.medicare.dto.PaymentDto;
import com.medicare.dto.UserDto;

public interface PurchaseService {

	public void savePurchasedItems(List<String>purchasedItems,UserDto userDto);

	public List<PaymentDto>getPurchasedItemsByUsername(String username);

}
