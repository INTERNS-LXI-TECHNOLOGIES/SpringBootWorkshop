package com.lxisoft.mockexam.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "QUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    private String question;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id",referencedColumnName = "id")
    private Answer answer;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Options> opts;

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

    public List<Options> getOpts() {
        return opts;
    }

    public void setOpts(List<Options> opts) {
        this.opts = opts;
    }

    public Question(int id, String question, Answer answer, List<Options> opts) {
        Id = id;
        this.question = question;
        this.answer = answer;
        this.opts = opts;
    }

    public Question()
    {

    }

    @Override
    public String toString() {
        return "Question{" +
                "Id=" + Id +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                ", opts=" + opts +
                '}';
    }
}
