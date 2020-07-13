package com.lxisoft.MockExam.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "QUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String question;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id",referencedColumnName = "id")
    private Answer answer;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Options> options;

    public Question(int id, String question, Answer answer, List<Options> options) {
        Id = id;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    public Question()
    {

    }
    
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public List<Options> getOption() {
        return options;
    }

    public void setOption(List<Options> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Question{" +
                "Id=" + Id +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                ", options=" + options +
                '}';
    }
}