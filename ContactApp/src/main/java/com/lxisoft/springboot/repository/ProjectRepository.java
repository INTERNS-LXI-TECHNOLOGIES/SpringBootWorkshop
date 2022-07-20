package com.lxisoft.springboot.repository;


import com.lxisoft.springboot.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByContactsContactId(int i);
}
