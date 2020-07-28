package com.lxisoft.MockexamSecurity.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnsOption() {
		return ansOption;
	}

	public void setAnsOption(String ansOption) {
		this.ansOption = ansOption;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
    

   

}

