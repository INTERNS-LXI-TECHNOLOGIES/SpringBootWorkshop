package com.lxisoft.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.lxisoft.model.User;
import com.lxisoft.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
