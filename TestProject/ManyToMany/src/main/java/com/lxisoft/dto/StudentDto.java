package com.lxisoft.dto;

import java.util.HashSet;
import java.util.Set;

import com.lxisoft.model.Course;
import com.lxisoft.model.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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