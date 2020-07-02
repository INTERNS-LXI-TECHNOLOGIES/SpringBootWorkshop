package com.lxisoft.mockExamSpringBoot.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Answer")
public class Answer implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String answer;
}
