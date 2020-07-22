package com.lxisoft.entity;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "COURSE")
public class Course implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "chapter")
	private String chapter;

	
	@ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<Student>();

    public Course() {
    }

    public Course(Integer id, String name, String chapter,List<Student> students) {
        this.id = id;
        this.name = name;
        this.chapter = chapter;
        this.students = students;
    }
	
	public void setStudents(List<Student> students) {
        this.students = students;
    }
    public List<Student> getStudents() {
        return students;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }	
	
}