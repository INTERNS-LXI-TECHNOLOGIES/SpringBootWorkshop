package com.lxisoft.carshowroom.service;

import org.springframework.ui.Model;

import com.lxisoft.carshowroom.entity.Car;

public interface CarService {

	void listCars(Integer pageNo, String sortBy, String carModel, Model model, Integer min, Integer max);

	void saveCar(Car car);

	void deleteCar(int carId);

	Car getCar(int carId);

}
