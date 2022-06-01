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
	public void listCars(Integer pageNo, String sortBy, Model model) {
		Pageable pageable = PageRequest.of(pageNo - 1, 10, Sort.by(sortBy));
		Page<Car> page = carRepository.findAll(pageable);
		setModels(sortBy, model, page, "home");
	}

	@Override
	public void filerCars(Integer min, Integer max, Model model, String sortBy, Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 10, Sort.by(sortBy));
		Page<Car> page = carRepository.findByExpectedPriceBetween(min, max, pageable);
		model.addAttribute("min", min);
		model.addAttribute("max", max);
		setModels(sortBy, model, page, "filter");
	}

	@Override
	public void searchCars(String carModel, Model model, String sortBy, Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 10, Sort.by(sortBy));
		Page<Car> page = carRepository.findByModelContaining(carModel, pageable);
		model.addAttribute("carModel", carModel);
		setModels(sortBy, model, page, "search");
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

	private void setModels(String sortBy, Model model, Page<Car> page, String navAction) {
		model.addAttribute("currentPage", page.getNumber() + 1);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("carList", page.getContent());
		model.addAttribute("sortBy", sortBy);
		model.addAttribute("navAction", navAction);
	}

}
