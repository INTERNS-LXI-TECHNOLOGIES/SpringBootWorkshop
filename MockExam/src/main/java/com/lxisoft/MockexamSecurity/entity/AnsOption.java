package com.lxisoft.MockexamSecurity.entity;
import javax.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "AnOption")
public class AnsOption implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    public String ansOption;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public AnsOption() {
    }

    public AnsOption(long id, String ansOption, Question question) {
        this.id = id;
        this.ansOption = ansOption;
        this.question = question;
    }

    public String getAOption() {
        return ansOption;
    }

    public void setAOption(String ansOption) {
        this.ansOption = ansOption;
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

}