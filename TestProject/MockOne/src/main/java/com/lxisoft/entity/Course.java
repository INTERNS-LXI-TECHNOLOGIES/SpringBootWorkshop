package com.lxisoft.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    public String courses;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Course() {
    }

    public Course(long id, String courses, Student student) {
        this.id = id;
        this.courses = courses;
        this.student = student;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
