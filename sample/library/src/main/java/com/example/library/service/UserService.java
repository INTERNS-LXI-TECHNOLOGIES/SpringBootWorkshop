package com.example.library.service;
import java.util.List;

import com.example.library.dto.UserDto;
public interface UserService {
	public UserDto addUser(UserDto userDto);
	public List<UserDto> getAllUser();
	public UserDto updateUser(Integer userId,UserDto user);
	public String deleteUser(Integer userId);
}
