package com.lxisoft.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Charactor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "charactor_id")
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "charactor_Name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private Actor actor;

    public Charactor() {}

    public Charactor(String name, String word) {
        this.name = name;

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

    public String getName() {
        return name;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}