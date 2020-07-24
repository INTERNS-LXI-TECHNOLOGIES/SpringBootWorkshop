package com.lxisoft.MockExamProject.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  String answer;

    @OneToOne
    @JoinColumn(name = "question_id",nullable = false)
    private Question question;

    public Answer() {
    }

    public Answer(long id, String answer, Question question) {
        this.id = id;
        this.answer = answer;
        this.question = question;
    }
   }