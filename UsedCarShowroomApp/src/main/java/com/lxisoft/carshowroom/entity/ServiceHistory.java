package com.lxisoft.carshowroom.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ServiceHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "service_date")
	private Date serviceDate;

	@Column(name = "total_kilometers")
	private Integer totalKilometers;

	@Column(name = "showroom")
	private String showroom;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public Integer getTotalKilometers() {
		return totalKilometers;
	}

	public void setTotalKilometers(Integer totalKilometers) {
		this.totalKilometers = totalKilometers;
	}

	public String getShowroom() {
		return showroom;
	}

	public void setShowroom(String showroom) {
		this.showroom = showroom;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
