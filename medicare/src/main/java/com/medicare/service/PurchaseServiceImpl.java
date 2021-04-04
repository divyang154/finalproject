package com.medicare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.dao.MedicineDao;
import com.medicare.dao.PaymentDao;
import com.medicare.dao.UserDao;
import com.medicare.dto.MedicineDto;
import com.medicare.dto.PaymentDto;
import com.medicare.dto.UserDto;

@Service(value="purchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	MedicineDao medicineDao;
	
	@Override
	public void savePurchasedItems(List<String> purchasedItems,UserDto userDto) {
		// TODO Auto-generated method stub
 
		String purchasedMedicineProductsString="";
		for (String string : purchasedItems) {
			purchasedMedicineProductsString=purchasedMedicineProductsString + ","+string;
		}
		purchasedMedicineProductsString=purchasedMedicineProductsString.substring(1, purchasedMedicineProductsString.length());
		paymentDao.savePurchasedItems(purchasedMedicineProductsString, userDto);
		
	}

	@Override
	public List<PaymentDto> getPurchasedItemsByUsername(String username) {
		// TODO Auto-generated method stub
		String medicineNameList="";
		UserDto userDto=userDao.getUser(username).stream().findFirst().get();
		List<PaymentDto> paymentDtoList=paymentDao.getPurchasedItemsByUsername(userDto.getUserId().toString());
		for (PaymentDto paymentDto : paymentDtoList) {
			String []Ids=paymentDto.getMedicineList().split(",");
			for(String string : Ids) {
				if(!string.equals("")) {
				MedicineDto medicineDto=medicineDao.getMedicineDao(Integer.parseInt(string)).stream().findFirst().get();
				medicineNameList=medicineNameList+"," +medicineDto.getMedicineName();
				}
			}
			medicineNameList=medicineNameList.substring(1, medicineNameList.length());
			paymentDto.setMedicineList(medicineNameList);
		}
		return paymentDtoList;
	}


}
