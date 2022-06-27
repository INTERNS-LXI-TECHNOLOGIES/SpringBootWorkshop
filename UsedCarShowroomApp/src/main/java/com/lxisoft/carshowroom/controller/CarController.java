package com.lxisoft.carshowroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lxisoft.carshowroom.entity.Car;
import com.lxisoft.carshowroom.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/")
	public String welcome() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(Model model, @RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "expectedPrice") String sortBy) {
		carService.listCars(pageNo, sortBy, model);
		return "home";
	}

	@GetMapping("/search")
	public String search(Model model, @RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "expectedPrice") String sortBy,
			@RequestParam(defaultValue = "") String carModel) {
		carService.searchCars(carModel, model, sortBy, pageNo);
		return "home";
	}

	@GetMapping("/filter")
	public String filter(Model model, @RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "expectedPrice") String sortBy, @RequestParam(defaultValue = "") Integer min,
			@RequestParam(defaultValue = "") Integer max) {
		carService.filerCars(min, max, model, sortBy, pageNo);
		return "home";
	}

	@PostMapping("/save")
	public String saveCar(@ModelAttribute Car car) {
		car = carService.saveCar(car);
		return "redirect:/car-details/" + car.getCarId();
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
		return "redirect:/home";
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

	@GetMapping("/car-details/{carId}")
	public String carDetails(@PathVariable int carId, Model model, @RequestParam(defaultValue = "view") String action) {
		Car car = carService.getCar(carId);
		model.addAttribute("car", car);
		model.addAttribute("action", action);
		return "carDetails";
	}
}
