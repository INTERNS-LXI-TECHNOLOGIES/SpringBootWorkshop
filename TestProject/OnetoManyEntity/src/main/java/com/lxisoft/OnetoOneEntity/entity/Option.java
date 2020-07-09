package com.lxisoft.OnetoOneEntity.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Optiontb")
public class Option implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String option;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public Option() {
    }

    public Option(long id, String option, Question question) {
        this.id = id;
        this.option = option;
        this.question = question;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
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

