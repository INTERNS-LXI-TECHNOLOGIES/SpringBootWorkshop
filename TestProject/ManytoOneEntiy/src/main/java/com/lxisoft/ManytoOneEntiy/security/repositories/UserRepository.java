package com.lxisoft.ManytoOneEntiy.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import net.guides.springboot.springbootmultipledatasources.security.entities.User;


public interface UserRepository extends JpaRepository<User, Integer>
{
 
}