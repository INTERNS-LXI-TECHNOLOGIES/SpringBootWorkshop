package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.User;
import com.lxisoft.mockexam.web.dto.UserRegistrationDto;

public interface UserService {

    User save(UserRegistrationDto registrationDto);

}
