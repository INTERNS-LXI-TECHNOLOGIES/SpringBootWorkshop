package com.lxisoft.mockexam.entity;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Answer")
    private String answer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

}
