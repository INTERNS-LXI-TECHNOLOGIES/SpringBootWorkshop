package com.lxisoft.carshowroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.lxisoft.carshowroom.entity.Car;
import com.lxisoft.carshowroom.repository.CarRepository;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public void listCars(Integer pageNo, String sortBy, String carModel, Model model) {
		Pageable pageable = PageRequest.of(pageNo - 1, 10, Sort.by(sortBy));
		Page<Car> page;
		if (carModel.isEmpty()) {
			page = carRepository.findAll(pageable);
		} else {
			page = carRepository.findByModelContaining(carModel, pageable);
		}
        model.addAttribute("currentPage", page.getNumber() + 1);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("carList", page.getContent());
        model.addAttribute("carModel", carModel);
        model.addAttribute("sortBy", sortBy);
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
