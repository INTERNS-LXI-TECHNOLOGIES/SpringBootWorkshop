package com.lxisoft.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	public Course findByName(String courseName);
}