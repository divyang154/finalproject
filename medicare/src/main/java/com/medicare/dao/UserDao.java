package com.medicare.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medicare.dto.UserDto;

public interface UserDao {

	public int saveUser(UserDto userDto);
	
	public List<UserDto> getUser(String username);
	
}
