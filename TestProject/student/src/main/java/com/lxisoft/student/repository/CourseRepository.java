package com.lxisoft.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lxisoft.student.entity.Course;



public interface CourseRepository extends JpaRepository<Course,Long> {
}