package com.lxisoft.mockexam.repository;

import com.lxisoft.mockexam.entity.Role;
import com.lxisoft.mockexam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleRepo")
public interface RoleRepo extends JpaRepository<Role,Integer> {

    public Role findByRole(String rolename);
}

