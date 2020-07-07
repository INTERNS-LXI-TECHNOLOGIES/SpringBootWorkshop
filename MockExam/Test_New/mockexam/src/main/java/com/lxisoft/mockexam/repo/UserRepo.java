package com.lxisoft.mockexam.repo;

import com.lxisoft.mockexam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User,Integer> {


}
