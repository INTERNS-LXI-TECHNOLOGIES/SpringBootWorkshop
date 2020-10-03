package com.lxisoft.model;
@Entity
public class User {

	@Id
	private int userId;
 private String name,contactNumber;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getContactNumber() {
	return contactNumber;
}

public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}
}
