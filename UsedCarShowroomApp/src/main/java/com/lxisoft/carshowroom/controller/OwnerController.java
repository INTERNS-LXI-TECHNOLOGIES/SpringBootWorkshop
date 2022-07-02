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

import com.lxisoft.carshowroom.entity.Car;
import com.lxisoft.carshowroom.entity.Owner;
import com.lxisoft.carshowroom.service.CarService;
import com.lxisoft.carshowroom.service.OwnerService;

@Controller
public class OwnerController {

	@Autowired
	private CarService carService;

	@Autowired
	private OwnerService ownerService;
	
	@GetMapping("/owner-details/{id}")
	public String viewOwnerDetails(@PathVariable Integer id, Model model) {
		Owner owner = ownerService.getOwner(id);
		model.addAttribute("owner", owner);
		model.addAttribute("action", "view");
		model.addAttribute("navAction", "owner");
		return "ownerDetails";
	}
	
	@GetMapping("/create-owner")
	public String createOwner(Model model) {
		model.addAttribute("owner", new Owner());
		model.addAttribute("action", "add");
		model.addAttribute("navAction", "owner");
		return "ownerDetails";
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/owner-details/{id}/edit")
	public String editCarDetails(@PathVariable Integer id, Model model) {
		Owner owner = ownerService.getOwner(id);
		model.addAttribute("owner", owner);
		model.addAttribute("action", "edit");
		model.addAttribute("navAction", "owner");
		return "ownerDetails";
	}
	
	@PostMapping("/save-owner")
	public String saveOwner(@ModelAttribute Owner owner) {
		owner = ownerService.saveOwner(owner);
		return "redirect:/owner-details/" + owner.getId();
	}

	@GetMapping("/delete-owner/{id}")
	public String deleteCar(@PathVariable int id) {
		ownerService.deleteOwner(id);
		return "redirect:/home";
	}

	@GetMapping("/owner/{id}/remove-car/{carId}")
	public String deleteCar(@PathVariable int carId, @PathVariable Integer id) {
		Car car = carService.getCar(carId);
		Owner owner = ownerService.getOwner(id);
		owner.getCars().remove(car);
		ownerService.saveOwner(owner);
		return "redirect:/owner-details/" + id;
	}

	@GetMapping("/add-car/{id}")
	public String createCar(@PathVariable int id, Model model) {
		Owner owner = ownerService.getOwner(id);
		List<Car> cars = carService.getCars();
		cars.removeAll(owner.getCars());
		Car car = new Car();
		owner.getCars().add(car);
		model.addAttribute("car", car);
		model.addAttribute("owner", owner);
		model.addAttribute("cars", cars);
		model.addAttribute("action", "view");
		model.addAttribute("navAction", "owner");
		return "ownerDetails";
    }
	
	@PostMapping("/owner/{id}/save-car")
	public String saveCar(@PathVariable int id, @ModelAttribute Car car) throws ParseException {
		Owner owner = ownerService.getOwner(id);
		car = carService.getCar(car.getCarId());
		owner.getCars().add(car);
		ownerService.saveOwner(owner);
		return "redirect:/owner-details/" + id;
	}
}
