package com.lxisoft.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "QnOption")
public class QnOption implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    public String qnOption;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public QnOption() {
    }

    public QnOption(long id, String qnOption, Question question) {
        this.id = id;
        this.qnOption = qnOption;
        this.question = question;
    }

    public String getQOption() {
        return qnOption;
    }

    public void setQOption(String qnOption) {
        this.qnOption = qnOption;
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
