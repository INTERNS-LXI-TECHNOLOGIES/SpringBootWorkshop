package com.lxisoft.student.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

@Entity
@Table(name = "coursetable")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String modules;

    @Column
    private double fee;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
  //  private Set<Student> students = new HashSet<>();
    private List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(Long id, String title, String modules, double fee, List<Student> students) {
        this.id = id;
        this.title = title;
        this.modules = modules;
        this.fee = fee;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

   
}