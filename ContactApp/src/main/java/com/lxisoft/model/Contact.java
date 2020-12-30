package com.lxisoft.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Contact")

public class Contact implements Serializable
{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int ID;
	@Column
	private String name;
	@Column
	private String number;
	@Column
	private String email;


public int getID() {

	return ID;
   }
   public void setID(int id) {

	ID = id;
   }
	public void setName(String name)
	{

		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setNumber(String number)
	{
		this.number=number;
	}
	public String getNumber()
	{
		return number;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return email;
	}
	@Override
	public String toString()
	{
		return "\n"+"name :"+name+"    number :"+number+"  email :"+email+"\n";
	}
}