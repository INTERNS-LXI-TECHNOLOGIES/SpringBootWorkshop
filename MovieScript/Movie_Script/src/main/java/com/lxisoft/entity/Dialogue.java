package com.lxisoft.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Dialogue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;



    @Column(name = "word")
    private String word;

     public Dialogue() {}

    public Dialogue(String name, String word) {
        this.name = name;
        this.word = word;
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

    public void setWord(String word) {
        this.word = word;
    }

    public String getName() {
        return name;
    }

    public String getWord() {
        return word;
    }


}