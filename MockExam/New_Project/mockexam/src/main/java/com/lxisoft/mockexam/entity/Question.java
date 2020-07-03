package com.lxisoft.mockexam.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Question")
    private String question;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private Set<Options> opt = new HashSet<Options>();

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "question")
    private Answer answer;


    @OneToOne(mappedBy = "question")
    private MCQ mcq;
}
