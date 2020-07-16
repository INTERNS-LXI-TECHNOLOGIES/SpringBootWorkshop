package com.lxisoft.ManytoMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lxisoft.ManytoMany.model.Student;



public interface StudentRepository extends JpaRepository<Student, Integer> {

}