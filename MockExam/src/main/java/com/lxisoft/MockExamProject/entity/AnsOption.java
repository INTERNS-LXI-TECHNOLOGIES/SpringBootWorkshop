package com.lxisoft.MockExamProject.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AnsOption")
public class AnsOption implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    public String ansOption;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public AnsOption() {
    }

    public AnsOption(long id, String ansOption, Question question) {
        this.id = id;
        this.ansOption = ansOption;
        this.question = question;
    }
}