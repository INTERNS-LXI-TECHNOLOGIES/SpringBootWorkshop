package com.lxisoft.MockExamProject.entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Question")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column
    private String question;

    @OneToOne(mappedBy = "question",cascade = CascadeType.ALL)
    private Answer answer;
    
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<AnsOption> ansOption;

    
    public Question(){

    }

    public Question(long id, String question,List<AnsOption> ansOption, Answer answer) {
        this.id = id;
        this.question = question;
        this.ansOption = ansOption;
        this.answer = answer;
    }
    }