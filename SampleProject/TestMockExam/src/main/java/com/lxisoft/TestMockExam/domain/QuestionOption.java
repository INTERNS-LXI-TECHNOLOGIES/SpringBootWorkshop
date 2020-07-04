package com.lxisoft.TestMockExam.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "questionOption")
public class QuestionOption implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column
    private String qnOption;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public QuestionOption() {
    }

    public QuestionOption(int id, String qnOption, Question question) {
        this.id = id;
        this.qnOption = qnOption ;
        this.question = question;
    }

    public String getQnOption() {
        return qnOption;
    }

    public void setQnOption(String qnOption) {
        this.qnOption = qnOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionOption)) return false;
        QuestionOption option1 = (QuestionOption) o;
        return getId() == option1.getId() &&
                Objects.equals(getQnOption(), option1.getQnOption());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", option='" + qnOption + '\'' +
                '}';
    }
}
