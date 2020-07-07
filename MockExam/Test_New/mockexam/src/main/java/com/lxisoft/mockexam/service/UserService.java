package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.User;
import com.lxisoft.mockexam.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void saveUser(User user)
    {
        userRepo.save(user);
    }

    public User findUserById(int id)
    {
      return userRepo.getOne(id);

    }
}
