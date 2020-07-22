package com.lxisoft.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lxisoft.student.entity.Student;



public interface StudentRepository extends JpaRepository<Student,Long> {
}