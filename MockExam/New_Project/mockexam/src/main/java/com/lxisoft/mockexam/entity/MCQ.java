package com.lxisoft.mockexam.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MCQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @OneToMany(mappedBy = "mcq")
    private Set<Options> options;
}
