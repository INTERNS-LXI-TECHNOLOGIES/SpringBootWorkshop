package com.lxisoft.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lxisoft.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}