package com.lxisoft.TestMockExam.repository;

import com.lxisoft.TestMockExam.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
