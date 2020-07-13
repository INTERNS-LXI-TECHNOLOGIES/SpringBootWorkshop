package com.lxisoft.ManytoManyEntity.entity;
import java.io.Serializable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questiontbl")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column
    private String question;

    @OneToOne(mappedBy = "question",cascade = CascadeType.ALL)
    private Answer answer;
    
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AnsOption> ansOption;

    
    public Question(){

    }

    public Question(long id, String question,List<AnsOption> ansOption, Answer answer) {
        this.id = id;
        this.question = question;
        this.ansOption = ansOption;
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

    public void setOptions(List<AnsOption> ansOption) {
        this.ansOption = ansOption;
    }
    public List<AnsOption> getAnsOption() {
        return ansOption;
    }
    
}