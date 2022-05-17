package com.lxisoft.carshowroom.service;

import org.springframework.ui.Model;

import com.lxisoft.carshowroom.entity.Car;

public interface CarService {

	void listAllCars(Integer pageNo, Model model);

	void saveCar(Car car);

	void deleteCar(int carId);

	Car getCar(int carId);

}
