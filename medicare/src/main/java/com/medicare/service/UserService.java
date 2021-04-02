package com.medicare.service;

import com.medicare.dto.UserDto;

public interface UserService {

	public int saveUser(UserDto userDto);
	
	public boolean authorizeLogin(String username,String password);
	
	public UserDto getUserByUsername(String username);
}
