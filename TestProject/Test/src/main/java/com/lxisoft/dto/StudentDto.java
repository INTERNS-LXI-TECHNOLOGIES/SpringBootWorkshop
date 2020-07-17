package com.lxisoft.dto;

import java.util.HashSet;
import java.util.Set;

import com.lxisoft.entity.Course;
import com.lxisoft.entity.Student;


public class StudentDto {
	private Integer id;
	private String name;
	private Set<String> courses = new HashSet<>();
	
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	
	
	public void setCourses(Set<String> courses) {
        this.courses = courses;
    }
    public Set<String> getCourses() {
        return courses;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}