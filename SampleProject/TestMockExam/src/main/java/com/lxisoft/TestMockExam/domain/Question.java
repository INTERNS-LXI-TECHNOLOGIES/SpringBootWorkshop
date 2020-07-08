package com.lxisoft.TestMockExam.domain;

import javax.persistence.*;
import java.io.Serializable;
//import java.util.List;
import java.util.*;

@Entity
@Table(name = "question")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column
    private String question;

    @OneToMany(mappedBy = "question")
    private List<QuestionOption> qnOption;

    @OneToOne(mappedBy = "question",cascade = CascadeType.ALL)
    private Answer answer;

    public Question(){

    }

    public Question(long id, String question, List<QuestionOption> qnOption, Answer answer) {
        this.id = id;
        this.question = question;
        this.qnOption = qnOption;
        this.answer = answer;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public List<QuestionOption> getQnOption() {
        return qnOption;
    }

    public void setQnOption(List<QuestionOption> qnOption) {
        this.qnOption = qnOption;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Question)) return false;
//        Question question1 = (Question) o;
//        return getId() == question1.getId() &&
//                Objects.equals(getQuestion(), question1.getQuestion());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId());
//    }
//
//    @Override
//    public String toString() {
//        return "Question{" +
//                "id=" + id +
//                ", question='" + question + '\'' +
//                '}';
//    }
}
