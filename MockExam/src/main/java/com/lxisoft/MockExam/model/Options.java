package com.lxisoft.MockExam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Options {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private String option;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	 public Options() {
	    }

	 public Options(long id, String option, Question question) {
		super();
		this.id = id;
		this.option = option;
		this.question = question;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	 @Override
	    public String toString() {
	        return "Options{" +
	                "option='" + option + '\'' +
	                '}';
	    }
	
}
