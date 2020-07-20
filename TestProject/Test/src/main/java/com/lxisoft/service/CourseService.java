package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxisoft.repository.CourseRepository;
import com.lxisoft.entity.*;

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
