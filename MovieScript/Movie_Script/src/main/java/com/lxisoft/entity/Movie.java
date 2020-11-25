package com.lxisoft.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;


    @Column(name = "scene1")
    private String scene1;

    @Column(name = "scene2")
    private String scene2;

    @Column(name = "scene3")
    private String scene3;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Actor actor;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Actor actor;

    public Movie() {}

    public Movie(String name, String scene1,String scene2,String scene3) {
        this.name = name;
        this.scene1 = scene1;
        this.scene2 = scene2;
        this.scene3 = scene3;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setScene1(String scene1) {
        this.scene1 = scene1;
    }

    public String getName() {
        return name;
    }

    public String getScene1() {
        return scene1;
    }

    public String getScene2() {
        return scene2;
    }

    public void setScene2(String scene2) {
        this.scene2 = scene2;
    }

    public String getScene3() {

        return scene3;
    }

    public void setScene3(String scene3) {
        this.scene3 = scene3;
    }

//    public void setScene1(String scene1) {
//        this.scene1 = scene1;
//    }
//
//    public String getName() {
//        return name;
//    }
}