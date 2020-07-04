package com.lxisoft.mockexam.entity;

import javax.persistence.*;

@Entity(name = "ANSWER")
public class Answer {

    @Id
    private int id;

    @Column(name = "ANSWER")
    private String answer;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}
