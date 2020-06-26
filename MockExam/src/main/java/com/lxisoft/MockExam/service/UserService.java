package com.lxisoft.MockExam.service;

import com.lxisoft.MockExam.entity.User;
import com.lxisoft.MockExam.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);

}
