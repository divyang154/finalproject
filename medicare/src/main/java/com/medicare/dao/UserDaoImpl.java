package com.medicare.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medicare.dto.MedicineDto;
import com.medicare.dto.UserDto;
import com.medicare.mapper.MedicineMapper;
import com.medicare.mapper.UserMapper;
@Repository(value="userDao")
public class UserDaoImpl implements UserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String insertQuery="insert into `user_tb` (`username`,`password`,`userEmail`,`userRole`) values (?,?,?,?)";
	private String selectQuery="select * from `user_tb`where username=?";

	@Override
	public int saveUser(UserDto userDto) {
		// TODO Auto-generated method stub
		int returnedInt=jdbcTemplate.update(insertQuery,new Object[] {userDto.getUsername(),userDto.getPassword(),userDto.getUsername(),userDto.getUserRole()});
		return returnedInt;
	}

	@Override
	public List<UserDto> getUser(String username) {
		// TODO Auto-generated method stub
		List<UserDto> userDtoList=(ArrayList<UserDto>)jdbcTemplate.query(selectQuery, new Object[] {username},new UserMapper());
		return userDtoList;
	}

}
