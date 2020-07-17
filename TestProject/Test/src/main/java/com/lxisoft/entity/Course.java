package com.lxisoft.entity;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
	@SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence")
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "courses")
	private Set<Student> students;
	
	
	public void setStudents(Set<Student> students) {
        this.students = students;
    }
    public Set<Student> getStudents() {
        return students;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
	
	
	
	
	
}