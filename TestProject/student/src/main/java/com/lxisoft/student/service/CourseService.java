package com.lxisoft.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.student.entity.Course;
import com.lxisoft.student.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public void saveCourse(Course course)
    {
    	courseRepository.save(course);
    }

    public List<Course> getRole()
    {
        return courseRepository.findAll();
    }

}