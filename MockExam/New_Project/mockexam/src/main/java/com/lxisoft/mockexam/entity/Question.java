package com.lxisoft.mockexam.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Question")
    private String question;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "question",cascade = CascadeType.ALL)
    private List<Option> options;

    @OneToOne(mappedBy = "question")
    private Answer answer;


}
