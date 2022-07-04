package com.lxisoft.springboot.repository;


import com.lxisoft.springboot.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
