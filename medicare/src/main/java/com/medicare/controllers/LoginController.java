package com.medicare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.medicare.dto.MedicineDto;
import com.medicare.forms.LoginForm;
import com.medicare.forms.MedicineForm;
import com.medicare.service.MedicineService;
import com.medicare.service.UserService;
import com.medicare.dto.UserDto;

@Controller
public class LoginController {
    @Autowired
	UserService userService;
    @Autowired
    MedicineService medicineService;
	private static final String loginForm="loginForm";
	private static final String userRole="userRole";
	
	
	@RequestMapping(value= {"/login"})
	public ModelAndView getLogin(@ModelAttribute(loginForm) LoginForm loginForm) {
		ModelAndView modelView=new ModelAndView();
		loginForm.setLoginSuccessfull(true);
		modelView.addObject("loginForm", loginForm);
		modelView.setViewName("login");
		return modelView;	
	}
	
	@RequestMapping(value= {"/checkLogin"})
	public ModelAndView checkLogin(@ModelAttribute(loginForm) LoginForm loginForm) {
		ModelAndView modelView=new ModelAndView();
		Boolean loginFlag=userService.authorizeLogin(loginForm.getUsername(), loginForm.getPassword());
		loginForm.setLoginSuccessfull(loginFlag);
		if(loginFlag==true) {
			UserDto userDto=userService.getUserByUsername(loginForm.getUsername());
			if(userDto.getUserRole().equals(userRole)){
				List<MedicineDto>medicineDtoList=medicineService.getAllActiveMedicineDto();
				modelView.setViewName("UserPurchaseList");
				MedicineForm medicineForm=new MedicineForm();
				medicineForm.setMedicineDtoList(medicineDtoList);
				modelView.addObject("addMedicineForm", medicineForm);
				return modelView;
			}
			else {
				
				
			}
		}
		else {
			
		}
		
		modelView.setViewName("addMedicine");
		modelView.addObject("loginForm", loginForm);
		return modelView;	
	}
	
}	