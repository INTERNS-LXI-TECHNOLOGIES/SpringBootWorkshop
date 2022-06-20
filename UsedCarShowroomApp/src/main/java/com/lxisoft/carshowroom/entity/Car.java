package com.lxisoft.carshowroom.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private Integer carId;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "model")
	private String model;

	@Column(name = "variant")
	private String variant;

	@Column(name = "year")
	private Integer year;

	@Column(name = "total_kilometers")
	private Integer totalKilometers;

	@Column(name = "expected_price")
	private Integer expectedPrice;

	@Column(name = "other_details")
	private String otherDetails;

	@OneToMany(mappedBy = "car")
	private Set<ServiceHistory> serviceHistories;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getTotalKilometers() {
		return totalKilometers;
	}

	public void setTotalKilometers(Integer totalKilometers) {
		this.totalKilometers = totalKilometers;
	}

	public Integer getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(Integer expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public Set<ServiceHistory> getServiceHistories() {
		return serviceHistories;
	}

	public void setServiceHistories(Set<ServiceHistory> serviceHistories) {
		this.serviceHistories = serviceHistories;
	}
}
