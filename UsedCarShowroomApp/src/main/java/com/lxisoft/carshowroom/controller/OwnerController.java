package com.lxisoft.carshowroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

	@GetMapping("/car/{carId}/delete-owner/{phoneNumber}")
	public String deleteOwner(@PathVariable int carId, @PathVariable long phoneNumber) {
		Car car = carService.getCar(carId);
		Owner owner = ownerService.getOwner(phoneNumber);
		owner.getCars().remove(car);
		ownerService.saveOwner(owner);
		return "redirect:/car-details/" + carId;
	}
}
