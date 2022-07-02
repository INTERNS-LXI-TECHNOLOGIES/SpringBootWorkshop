package com.lxisoft.carshowroom.service;

import java.util.List;

import org.springframework.ui.Model;

import com.lxisoft.carshowroom.entity.Car;

public interface CarService {

	void listCars(Integer pageNo, String sortBy, Model model);

	void filerCars(Integer min, Integer max, Model model, String sortBy, Integer pageNo);

	void searchCars(String carModel, Model model, String sortBy, Integer pageNo);

	Car saveCar(Car car);

	void deleteCar(int carId);

	Car getCar(int carId);

	List<Car> getCars();

}
