package com.lxisoft.carshowroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.carshowroom.repository.CarRepository;
import com.lxisoft.carshowroom.entity.Car;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> listAllCars() {
		return carRepository.findAll();
	}

	@Override
	public void saveCar(Car car) {
		carRepository.save(car);
	}

	@Override
	public void deleteCar(int carId) {
		carRepository.deleteById(carId);
	}

	@Override
	public Car getCar(int carId) {
		return carRepository.findById(carId).get();
	}

}
