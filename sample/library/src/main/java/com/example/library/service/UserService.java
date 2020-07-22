package com.example.library.service;

import java.util.List;

import com.example.library.model.Library;

public interface UserService 
{
	public Library addUser(Library library);
	public List<Library>getAllUsers();
	public Library updateUser(Long userId,Library library);
	public String deleteUser(Long userId);
}
