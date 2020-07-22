package com.lxisoft.student.dto;

import com.lxisoft.student.entity.Course;
import com.lxisoft.student.entity.Student;

public class StudentModel {

    private Course course;

    private Student student1;

    private Student student2;

    private Student student3;


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent1() {
        return student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }

    public Student getStudent2() {
        return student2;
    }

    public void setStudent2(Student student2) {
        this.student2 = student2;
    }

    public Student getStudent3() {
        return student3;
    }

    public void setStudent3(Student student3) {
        this.student3 = student3;
    }


}