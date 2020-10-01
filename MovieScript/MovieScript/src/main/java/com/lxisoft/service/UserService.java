package com.lxisoft.service;

import com.lxisoft.model.User;
import com.lxisoft.repository.UserReppo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserReppo userReppo;

    @Transactional
    public List<User> getAllUsers()
    {
        return userReppo.findAll();
    }

    @Transactional
    public void saveUser(User user)
    {
        userReppo.save(user);
    }
    @Transactional
    public  void deleteUser(int userId)
    {
        userReppo.delete(userId);
    }

}