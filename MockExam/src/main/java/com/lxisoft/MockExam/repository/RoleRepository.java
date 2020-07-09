package com.lxisoft.MockExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lxisoft.MockExam.model.Role;

@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role,Long> {

}
