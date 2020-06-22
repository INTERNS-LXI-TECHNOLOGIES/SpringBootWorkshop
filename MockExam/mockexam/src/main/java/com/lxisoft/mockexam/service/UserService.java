package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.Role;
import com.lxisoft.mockexam.entity.User;
import com.lxisoft.mockexam.repository.RoleRepo;
import com.lxisoft.mockexam.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void saveUser(User user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        user.setRoles(new HashSet<>(roleRepo.findAll()));
        userRepo.save(user);
    }
}
