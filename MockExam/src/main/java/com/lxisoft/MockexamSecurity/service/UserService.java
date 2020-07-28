package com.lxisoft.MockexamSecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.lxisoft.MockexamSecurity.model.User;
import com.lxisoft.MockexamSecurity.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}