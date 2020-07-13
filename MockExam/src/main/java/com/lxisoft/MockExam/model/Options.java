package com.lxisoft.MockExam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Options {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String opt;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	 public Options() {
	    }

	 public Options(int id, String opt, Question question) {
		super();
		this.id = id;
		this.opt = opt;
		this.question = question;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOption() {
		return opt;
	}
	public void setOption(String opt) {
		this.opt = opt;
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
	                "opt='" + opt + '\'' +
	                '}';
	    }
	
}
