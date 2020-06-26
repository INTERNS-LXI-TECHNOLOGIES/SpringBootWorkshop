package com.lxisoft.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mockexamtb")
public class ExamModel implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String  question;

	@Column
	private String opt1;

	@Column
	private String opt2;

	@Column
	private String opt3;

	@Column
	private String opt4;

	@Column
	private String ans;

	
	public void setQuestion(String question)
	{
		this.question = question;
	}
	public String getQuestion()
	{
		return question;
	}
	public void setId(int qNo)
	{
		this.id=qNo;
	}
	public int getId()
	{
		return id;
	}
	public void setOpt1(String opt1)
	{
		this.opt1=opt1;
	}
	public String getOpt1()
	{
		return opt1;
	}
	public void setOpt2(String opt2)
	{
		this.opt2=opt2;
	}
	public String getOpt2()
	{
		return opt2;
	}
	public void setOpt3(String opt3)
	{
		this.opt3=opt3;
	}
	public String getOpt3()
	{
		return opt3;
	}
	public void setOpt4(String opt4)
	{
		this.opt4=opt4;
	}
	public String getOpt4()
	{
		return opt4;
	}
	public void setAnswer(String ans)
	{
		this.ans=ans;
	}
	public String getAnswer()
	{
		return ans;
	}


}