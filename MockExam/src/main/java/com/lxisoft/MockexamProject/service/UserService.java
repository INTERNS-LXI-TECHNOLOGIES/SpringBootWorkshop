package com.lxisoft.MockexamProject.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.lxisoft.MockexamProject.model.User;
import com.lxisoft.MockexamProject.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}