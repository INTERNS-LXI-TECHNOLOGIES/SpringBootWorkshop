package com.lxisoft.mockexam.repository;

import com.lxisoft.mockexam.entity.Role;
import com.lxisoft.mockexam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("RoleRepo")
public interface RoleRepo extends JpaRepository<Role,Integer> {



}

