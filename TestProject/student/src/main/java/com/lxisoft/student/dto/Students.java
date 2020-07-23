package com.lxisoft.student.dto;

import com.lxisoft.student.entity.Course;
import com.lxisoft.student.entity.Student;

public class Students {

    private Student student;

    private Course course;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

	
}