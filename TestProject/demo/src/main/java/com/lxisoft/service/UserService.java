package com.lxisoft.service;

import com.lxisoft.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}