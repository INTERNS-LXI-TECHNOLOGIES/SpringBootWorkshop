package com.lxisoft.carshowroom.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Owner {

	@Id
	@Column(name = "phone_number")
	private long phoneNumber;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
        name = "car_owner", 
        joinColumns = { @JoinColumn(name = "phone_number") }, 
        inverseJoinColumns = { @JoinColumn(name = "car_id") }
    )
	Set<Car> cars = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

}
