package com.medicare.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.medicare.dto.MedicineDto;
import com.medicare.dto.PaymentDto;
import com.medicare.dto.UserDto;
import com.medicare.forms.MedicineForm;
import com.medicare.forms.PaymentForm;
import com.medicare.service.MedicineService;
import com.medicare.service.PurchaseService;

@Controller
public class PaymentController {

	@Autowired
	MedicineService medicineService;
	
    @Autowired
    PurchaseService purchaseService;
	
    private static final String addMedicineForm="addMedicineForm";
    
	@RequestMapping(value= {"/payAndSave"})
	public ModelAndView payAndSave(@ModelAttribute(	) MedicineForm medicineForm,HttpSession session) {
		ModelAndView modelView=new ModelAndView();
		String[]selectedInt=(String[]) session.getAttribute("selectedInt");
		List<String> selectedIntList = Arrays.asList(selectedInt);
		UserDto userDto=(UserDto)session.getAttribute("userDto");
		purchaseService.savePurchasedItems(selectedIntList,userDto);
		List<PaymentDto>paymentDtoList=purchaseService.getPurchasedItemsByUsername(userDto.getUsername());
		PaymentForm paymentForm=new PaymentForm();
		paymentForm.setPaymentDtoList(paymentDtoList);
		modelView.addObject("paymentForm", paymentForm);
		modelView.setViewName("PurchaseMadeByUser");
		return modelView;	
	}
	
	@RequestMapping(value= {"/backToPurchaseMedicine"})
	public ModelAndView backToPurchaseMedicine(@ModelAttribute(	) PaymentForm paymentForm,HttpSession session) {
		ModelAndView modelView=new ModelAndView();
		List<MedicineDto>medicineDtoList=medicineService.getAllActiveMedicineDto();
		modelView.setViewName("UserPurchaseList");
		MedicineForm medicineForm=new MedicineForm();
		medicineForm.setMedicineDtoList(medicineDtoList);
		modelView.addObject("addMedicineForm", medicineForm);
		return modelView;
	}
}
