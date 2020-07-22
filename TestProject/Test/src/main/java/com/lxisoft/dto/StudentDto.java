package com.lxisoft.dto;

import java.util.*;
import com.lxisoft.entity.Course;
import com.lxisoft.entity.Student;


public class StudentDto {
	private Integer id;
	private String name;
	private String age;
	private String chapter;
	private List<String> courses = new ArrayList<>();
	private Student student;
    private Course course;
    private Student student1;
    private Student student2;
    private Student student3;
    private Course course1;
    private Course course2;
    private Course course3;
    
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
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	
	
	public void setCourses(List<String> courses) {
        this.courses = courses;
    }
    public List<String> getCourses() {
        return courses;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
    public String getChapter() {
        return chapter;
    }

   

}