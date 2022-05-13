package com.lxisoft.carshowroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lxisoft.carshowroom.service.CarService;
import com.lxisoft.carshowroom.entity.Car;

@Controller
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/")
	public String home(Model model) {
		List<Car> carList = carService.listAllCars();
		model.addAttribute("carList", carList);
		return "home";
	}

	@PostMapping("/save")
	public String saveCar(@ModelAttribute Car car) {
		carService.saveCar(car);
		return "redirect:/";
	}

	@GetMapping("/create")
	public String createCar(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("caption", "ADD NEW CAR");
		return "createOrUpdateCar";
	}

	@GetMapping("/delete/{carId}")
	public String deleteCar(@PathVariable int carId) {
		carService.deleteCar(carId);
		return "redirect:/";
	}

	@GetMapping("/edit/{carId}")
	public String editCar(@PathVariable int carId, Model model) {
		Car car = carService.getCar(carId);
		model.addAttribute("car", car);
		model.addAttribute("caption", "EDIT CAR");
		return "createOrUpdateCar";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
