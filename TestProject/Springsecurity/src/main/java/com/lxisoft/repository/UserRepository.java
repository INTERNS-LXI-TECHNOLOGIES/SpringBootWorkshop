package com.lxisoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lxisoft.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}