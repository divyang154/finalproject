package com.medicare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.dao.UserDao;
import com.medicare.dto.UserDto;
@Service(value="userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	public static final String role="userRole";
	
	@Override
	public int saveUser(UserDto userDto) {
		// TODO Auto-generated method stub
		userDto.setUserRole(role);
		int returnedUser=userDao.saveUser(userDto);
		return returnedUser;
	}
	
	public boolean authorizeLogin(String username,String password) {
		boolean loginAuthorized=true;

		String error = "";
		UserDto user = null;
		if (username == null || username.length() <= 0) {
			loginAuthorized=false;

		} else if (password == null || password.length() <= 0) {
			loginAuthorized=false;

		} else {

			user = userDao.getUser(username).stream().findFirst().get();
			if (!user.getPassword().equals(password)) {
				loginAuthorized=false;
			} else {
				//login is proper no issues with it
			}

		}
		return loginAuthorized;
	}

	@Override
	public UserDto getUserByUsername(String username) {
		// TODO Auto-generated method stub
		UserDto userDto=userDao.getUser(username).stream().findFirst().get();
		return userDto;
	}

}
