package com.lxisoft.mockexam.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String opt;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Options() {
    }

    public Options(int id, String opt, Question question) {
        this.id = id;
        this.opt = opt;
        this.question = question;
    }
}
