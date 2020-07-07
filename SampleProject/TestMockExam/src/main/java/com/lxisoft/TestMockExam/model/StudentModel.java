package com.lxisoft.TestMockExam.model;

import com.lxisoft.TestMockExam.domain.Course;
import com.lxisoft.TestMockExam.domain.Student;

public class StudentModel {

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
