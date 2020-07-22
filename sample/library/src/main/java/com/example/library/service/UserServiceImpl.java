package com.example.library.service;

import java.util.List;

import javax.annotation.Resource;

import com.example.library.model.Library;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;
	@Resource
	private BookRepository bookRepository;
	
	@Override
	public Library addUser(Library library) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Library> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Library updateUser(Long userId, Library library) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
