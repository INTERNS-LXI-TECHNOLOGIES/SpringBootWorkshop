package com.lxisoft.OnetoOneEntity.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "optiontb")
public class AnsOption implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ansOption;

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

    public String getAnsOption() {
        return ansOption;
    }

    public void setAnsOption(String option) {
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

