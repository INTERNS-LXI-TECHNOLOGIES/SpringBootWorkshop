package com.lxisoft.mockexam.repository;

import com.lxisoft.mockexam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepo")
public interface UserRepo extends JpaRepository<User,Integer> {

    public User findUserByUsername(String username);

}
