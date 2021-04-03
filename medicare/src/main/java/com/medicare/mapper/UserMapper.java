package com.medicare.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medicare.dto.UserDto;

public class UserMapper implements RowMapper<UserDto>{

@Override
public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
	// TODO Auto-generated method stub
	UserDto userDto=new UserDto();
	userDto.setUsermail(rs.getString("username"));
	userDto.setPassword(rs.getString("password"));
	userDto.setUsername(rs.getString("userEmail"));
	userDto.setUserRole(rs.getString("userRole"));
	userDto.setUserId(rs.getInt("userId"));
	return userDto;
}
}
