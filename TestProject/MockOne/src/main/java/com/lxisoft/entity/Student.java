package com.lxisoft.entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column
    private String student;

    
    @ManyToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Course> courses;

    
    public Student(){

    }

    public Student(long id, String student,List<Course> courses) {
        this.id = id;
        this.student = student;
        this.courses = courses;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getStudent() {
        return student;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public List<Course> getCourses() {
        return courses;
    }
    
}
