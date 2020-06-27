package com.lxisoft.MockExam.service;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.lxisoft.MockExam.model.User;
import com.lxisoft.MockExam.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
