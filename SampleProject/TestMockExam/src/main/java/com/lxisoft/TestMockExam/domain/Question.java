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
    private  int id;

    @Column
    private String question;

    @OneToOne(mappedBy = "question", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Answer answer;

    @OneToMany(mappedBy = "question",
            cascade = CascadeType.ALL)
    private Set<Option> option = new HashSet<>();

    public Question(){

    }

    public Question(String question){
        this.question = question;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
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

    public Set<Option> getOptions() {
        return option;
    }

    public void setOptions(Set<Option> options) {
        this.option = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question1 = (Question) o;
        return getId() == question1.getId() &&
                Objects.equals(getQuestion(), question1.getQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                '}';
    }
}
