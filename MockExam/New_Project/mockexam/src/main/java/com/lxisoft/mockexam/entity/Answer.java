package com.lxisoft.mockexam.entity;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Answer")
    private String answer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;

    @OneToOne(mappedBy = "answer")
    private MCQ mcq;
}
