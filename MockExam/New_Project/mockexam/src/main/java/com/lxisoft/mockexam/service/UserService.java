package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.User;
import com.lxisoft.mockexam.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);

}
