package com.lxisoft.TestMockExam.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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
        //this.question.setAnswer(this);
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Answer)) return false;
//        Answer answer1 = (Answer) o;
//        return getId() == answer1.getId() &&
//                Objects.equals(getAnswer(), answer1.getAnswer());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId());
//    }
//
//    @Override
//    public String toString() {
//        return "Answer{" +
//                "id=" + id +
//                ", answer='" + answer + '\'' +
//                '}';
//    }
}
