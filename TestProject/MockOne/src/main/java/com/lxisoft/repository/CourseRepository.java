package com.lxisoft.repository;
import com.lxisoft.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
