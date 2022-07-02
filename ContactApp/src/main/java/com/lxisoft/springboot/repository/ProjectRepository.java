package com.lxisoft.springboot.repository;


import com.lxisoft.springboot.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ProjectRepository implements JpaRepository<Project, Integer> {
}
