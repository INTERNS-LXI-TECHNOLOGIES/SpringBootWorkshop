package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.Role;
import com.lxisoft.mockexam.entity.User;
import com.lxisoft.mockexam.repository.RoleRepo;
import com.lxisoft.mockexam.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public interface UserService extends UserDetailsService {

     void saveUser(User user);

}
