package com.lxisoft.mockexam.entity;

import javax.persistence.*;

@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private Question question;

}
