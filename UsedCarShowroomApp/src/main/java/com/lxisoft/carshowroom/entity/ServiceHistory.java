package com.lxisoft.carshowroom.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ServiceHistory {

	@Id
	@Column(name = "service_date")
	private Date serviceDate;

	@Column(name = "total_kilometers")
	private Integer totalKilometers;

	@Column(name = "showroom")
	private String showroom;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setDate(Date serviceDate) {
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
