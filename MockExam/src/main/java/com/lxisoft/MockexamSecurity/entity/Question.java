package com.lxisoft.MockexamSecurity.entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
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

    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<AnsOption> getAnsOption() {
		return ansOption;
	}

	public void setAnsOption(List<AnsOption> ansOption) {
		this.ansOption = ansOption;
	}

	public Question(){

    }

    public Question(long id, String question,List<AnsOption> ansOption, Answer answer) {
        this.id = id;
        this.question = question;
        this.ansOption = ansOption;
        this.answer = answer;
    }

  
    
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                ", ansOption=" + ansOption +
                '}';
    }
    
}

