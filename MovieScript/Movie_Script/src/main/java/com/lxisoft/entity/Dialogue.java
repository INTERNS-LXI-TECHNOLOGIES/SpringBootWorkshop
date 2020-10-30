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

  //  @NotBlank(message = "Dialogue is mandatory")
    @Column(name = "dialogue")
    private String dialogue;

    @NotBlank(message = "Dialogue is mandatory")
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

    public void setWord(String dialogue) {
        this.word = word;
    }

    public String getName() {
        return name;
    }

    public String getWord() {
        return word;
    }

//    public void setDialogue(String dialogue) {
//        this.dialogue = dialogue;
//    }
//    public String getDialogue() {
//        return dialogue;
//    }

}