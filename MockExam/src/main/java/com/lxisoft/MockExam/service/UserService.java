package com.lxisoft.MockExam.service;

import com.lxisoft.MockExam.model.User;
import com.lxisoft.MockExam.web.dto.UserRegistrationDto;

public interface UserService {

	User save(UserRegistrationDto registrationDto);
}
