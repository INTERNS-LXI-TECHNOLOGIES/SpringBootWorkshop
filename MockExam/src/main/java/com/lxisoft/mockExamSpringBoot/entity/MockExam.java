package com.lxisoft.mockExamSpringBoot.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MockExamTable")
public class MockExam implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    private Set<Question> question;

    public MockExam(){
       this.question = new HashSet<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setQuestion(Set<Question> question) {
        this.question = question;
    }

    public Set<Question> getQuestion() {
        return question;
    }
}
