package com.lxisoft.OnetoOneEntity.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.lxisoft.OnetoOneEntity.entity.Answer;
import com.lxisoft.OnetoOneEntity.entity.Question;


@Entity
public class ExamModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
     
    @Column
    private String question;
    
    
    @Column
    private String answer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
}