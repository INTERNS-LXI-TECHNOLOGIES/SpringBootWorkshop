package com.lxisoft.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Actor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
    
    @NotBlank(message = "Charactor is mandatory")
    @Column(name = "charactor")
    private String charactor;

    @Column(name = "phone_no")
    private long phoneNo;
    
    public Actor() {}

    public Actor(String name, String charactor) {
        this.name = name;
        this.charactor = charactor;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCharactor(String charactor) {
        this.charactor = charactor;
    }

    public String getName() {
        return name;
    }

    public String getCharactor() {
        return charactor;
    }

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
}