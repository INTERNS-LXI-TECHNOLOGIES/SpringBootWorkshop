package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.Role;
import com.lxisoft.mockexam.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepo roleRepo;

    public void saveRole(Role role)
    {
        roleRepo.save(role);
    }

    public List<Role> getRole()
    {
        return roleRepo.findAll();
    }



}
