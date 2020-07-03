package com.lxisoft.TestMockExam.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "option")
public class Option implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String option;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public Option() {
    }

    public Option(int id, String option, Question question) {
        this.id = id;
        this.option = option;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
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
        if (!(o instanceof Option)) return false;
        Option option1 = (Option) o;
        return getId() == option1.getId() &&
                Objects.equals(getOption(), option1.getOption());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", option='" + option + '\'' +
                '}';
    }
}
