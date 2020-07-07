package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.Role;
import com.lxisoft.mockexam.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepo roleRepo;

    public void saveRole(Role role)
    {
        roleRepo.save(role);
    }
}
