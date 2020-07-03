package com.lxisoft.mockexam.entity;

import javax.persistence.*;

@Entity
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String opt1;

    private String opt2;

    private String opt3;

    private String opt4;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "mcq_id")
    private MCQ mcq;

}
