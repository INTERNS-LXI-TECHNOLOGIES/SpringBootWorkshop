package com.lxisoft.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Dialogue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Dialogue is mandatory")
    @Column(name = "dialogue")
    private String dialogue;

//    @Column(name = "dialogue")
//    private String dialogue;

     public Dialogue() {}

    public Dialogue(String name, String dialogue) {
        this.name = name;
        this.dialogue = dialogue;
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

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public String getName() {
        return name;
    }

    public String getDialogue() {
        return dialogue;
    }

//    public void setDialogue(String dialogue) {
//        this.dialogue = dialogue;
//    }
//    public String getDialogue() {
//        return dialogue;
//    }

}