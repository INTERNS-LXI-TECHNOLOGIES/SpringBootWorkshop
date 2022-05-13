package com.lxisoft.carshowroom.service;

import java.util.List;

import com.lxisoft.carshowroom.entity.Car;

public interface CarService {

	List<Car> listAllCars();

	void saveCar(Car car);

	void deleteCar(int carId);

	Car getCar(int carId);

}
