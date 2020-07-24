package com.lxisoft.MockExamProject.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.lxisoft.MockExamProject.model.User;
import com.lxisoft.MockExamProject.web.dto.UserRegistrationDto;


public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}