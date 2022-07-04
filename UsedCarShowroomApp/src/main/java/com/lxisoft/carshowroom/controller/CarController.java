package com.lxisoft.carshowroom.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lxisoft.carshowroom.entity.Car;
import com.lxisoft.carshowroom.entity.Owner;
import com.lxisoft.carshowroom.service.CarService;
import com.lxisoft.carshowroom.service.OwnerService;

@Controller
public class CarController {

	@Autowired
	private CarService carService;

	@Autowired
	private OwnerService ownerService;

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
		model.addAttribute("action", "add");
		model.addAttribute("navAction", "car");
		return "carDetails";
	}

	@GetMapping("/delete/{carId}")
	public String deleteCar(@PathVariable int carId) {
		carService.deleteCar(carId);
		return "redirect:/home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/car-details/{carId}/edit")
	public String editCarDetails(@PathVariable int carId, Model model) {
		Car car = carService.getCar(carId);
		model.addAttribute("car", car);
		model.addAttribute("action", "edit");
		model.addAttribute("navAction", "car");
		return "carDetails";
	}

	@GetMapping("/car-details/{carId}")
	public String viewCarDetails(@PathVariable int carId, Model model) {
		Car car = carService.getCar(carId);
		model.addAttribute("car", car);
		model.addAttribute("action", "view");
		model.addAttribute("navAction", "car");
		return "carDetails";
	}

	@GetMapping("/car/{carId}/remove-owner/{id}")
	public String deleteOwner(@PathVariable int carId, @PathVariable Integer id) {
		Car car = carService.getCar(carId);
		Owner owner = ownerService.getOwner(id);
		owner.getCars().remove(car);
		ownerService.saveOwner(owner);
		return "redirect:/car-details/" + carId;
	}

	@GetMapping("/add-owner/{carId}")
	public String createOwner(@PathVariable int carId, Model model, @RequestParam(defaultValue = "") Integer ownerId) {
		Car car = carService.getCar(carId);
		List<Owner> owners = ownerService.getOwners();
		owners.removeAll(car.getOwners());
		Owner owner = null == ownerId ? new Owner() : ownerService.getOwner(ownerId);
		car.getOwners().add(owner);
		model.addAttribute("car", car);
		model.addAttribute("owner", owner);
		model.addAttribute("owners", owners);
		model.addAttribute("action", "view");
		model.addAttribute("navAction", "car");
		return "carDetails";
    }

	@PostMapping("/car/{carId}/save-owner")
	public String saveOwner(@PathVariable int carId, @ModelAttribute Owner owner) throws ParseException {
		Car car = carService.getCar(carId);
		owner = ownerService.getOwner(owner.getId());
		owner.getCars().add(car);
		ownerService.saveOwner(owner);
		return "redirect:/car-details/" + carId;
	}
}
