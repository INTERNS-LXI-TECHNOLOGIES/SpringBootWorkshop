package com.lxisoft.MockexamProject.entity;

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

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}