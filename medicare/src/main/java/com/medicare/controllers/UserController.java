package com.medicare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.medicare.dto.UserDto;
import com.medicare.forms.LoginForm;
import com.medicare.forms.UserForm;
import com.medicare.service.UserService;

@RestController
public class UserController {
    @Autowired  
	UserService userService;
	private static final String registerUserForm="registerUserForm";
	private static final String loginForm="loginForm";

	@RequestMapping(value= {"/registerUser"})
	public ModelAndView registerUser(@ModelAttribute(registerUserForm) UserForm userForm) {
		ModelAndView modelView=new ModelAndView();
		modelView.setViewName("registerUser");
		return modelView;
	}
	
	@RequestMapping(value= {"/saveRegisterUser"})
	public ModelAndView saveRegisterUser(@ModelAttribute(registerUserForm) UserForm userForm) {
		ModelAndView modelView=new ModelAndView();
		userService.saveUser(convertToDto(userForm));
		LoginForm loginForm=new LoginForm();
		modelView.addObject("loginForm", loginForm);
		modelView.setViewName("login");
		return modelView;	
	}
	
	public UserDto convertToDto(UserForm userForm){
		UserDto userDto=new UserDto();
		userDto.setPassword(userForm.getPassword());
		userDto.setUsername(userForm.getUsername());
		userDto.setUsermail(userForm.getUsermail());
		return userDto;
	}
	
	
}
