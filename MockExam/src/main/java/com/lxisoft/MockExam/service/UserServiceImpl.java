package com.lxisoft.MockExam.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxisoft.MockExam.model.Role;
import com.lxisoft.MockExam.model.User;
import com.lxisoft.MockExam.repository.UserRepository;
import com.lxisoft.MockExam.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(),
				registrationDto.getLastName(), registrationDto.getEmail(), 
				registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}

}
