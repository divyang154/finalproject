package com.medicare.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.medicare.dto.MedicineDto;
import com.medicare.dto.UserDto;
import com.medicare.forms.LoginForm;
import com.medicare.forms.MedicineForm;
import com.medicare.service.MedicineService;
import com.medicare.service.UserService;



@RestController
public class LoginController {
    @Autowired
	UserService userService;
    @Autowired
    MedicineService medicineService;
	private static final String addMedicineForm="addMedicineForm";
	private static final String loginForm="loginForm";
	private static final String userRole="userRole";
	private static final String adminRole="adminRole";
	
	@RequestMapping(value= {"/login"})
	public ModelAndView getLogin(@ModelAttribute LoginForm loginForm) {
		ModelAndView modelView=new ModelAndView();
		loginForm.setLoginSuccessfull(true);
		modelView.addObject("loginForm", loginForm);
		modelView.setViewName("login");
		return modelView;	
	}
	
	@RequestMapping(value= {"/checkLogin"})
	public ModelAndView checkLogin(@ModelAttribute LoginForm loginForm,HttpSession session,@ModelAttribute MedicineForm addMedicineForm) {
		ModelAndView modelView=new ModelAndView();
		Boolean loginFlag=userService.authorizeLogin(loginForm.getUsername(), loginForm.getPassword());
		loginForm.setLoginSuccessfull(loginFlag);
		if(loginFlag==true) {
			UserDto userDto=userService.getUserByUsername(loginForm.getUsername());
			if(userDto.getUserRole().equals(userRole)){
				List<MedicineDto>medicineDtoList=medicineService.getAllActiveMedicineDto();
				session.setAttribute("userDto", userDto);
				modelView.setViewName("UserPurchaseList");
				addMedicineForm.setMedicineDtoList(medicineDtoList);
				modelView.addObject("addMedicineForm", addMedicineForm);
			}
			if(userDto.getUserRole().equals(adminRole)){
				List<MedicineDto> medicineDtoList=medicineService.getAllMedicineDto();
				modelView.setViewName("showAllMedicine");
				addMedicineForm.setMedicineDtoList(medicineDtoList);
				modelView.addObject("addMedicineForm", addMedicineForm);
				
			}
		}
		
		
		modelView.setViewName("addMedicine");
		modelView.addObject("loginForm", loginForm);
		return modelView;	
	}
	
}	