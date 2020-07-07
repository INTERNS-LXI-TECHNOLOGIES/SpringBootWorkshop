package com.lxisoft.mockexam.repo;

import com.lxisoft.mockexam.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface RoleRepo extends JpaRepository<Role,Integer> {
}
