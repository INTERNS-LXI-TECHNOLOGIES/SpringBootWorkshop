package com.lxisoft.student.dto;

import com.lxisoft.student.entity.Course;
import com.lxisoft.student.entity.Student;

public class CourseModel {

    private Student student;

    private Course course1;

    private Course course2;

    private Course course3;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse1() {
        return course1;
    }

    public void setCourse1(Course course1) {
        this.course1 = course1;
    }

    public Course getCourse2() {
        return course2;
    }

    public void setCourse2(Course course2) {
        this.course2 = course2;
    }

    public Course getCourse3() {
        return course3;
    }

    public void setCourse3(Course course3) {
        this.course3 = course3;
    }


}

