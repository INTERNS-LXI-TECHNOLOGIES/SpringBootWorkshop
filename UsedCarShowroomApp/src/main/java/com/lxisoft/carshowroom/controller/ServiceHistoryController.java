package com.lxisoft.carshowroom.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lxisoft.carshowroom.entity.Car;
import com.lxisoft.carshowroom.entity.ServiceHistory;
import com.lxisoft.carshowroom.service.CarService;
import com.lxisoft.carshowroom.service.ServiceHistoryService;

@Controller
public class ServiceHistoryController {

	@Autowired
	private ServiceHistoryService serviceHistoryService;

	@Autowired
	private CarService carService;
	
	@InitBinder
	public void initBinder(WebDataBinder bind) {
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    simpleDateFormat.setLenient(false);
	    bind.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
	}

	@GetMapping("/car/{carId}/delete-service-history/{id}")
	public String deleteServiceHistory(@PathVariable int carId, @PathVariable Integer id) throws ParseException {
		serviceHistoryService.deleteServiceHistory(id);
		return "redirect:/car-details/" + carId;
	}
	
	@PostMapping("/car/{carId}/save-service-history")
	public String saveServiceHistory(@PathVariable int carId, @ModelAttribute ServiceHistory serviceHistory) throws ParseException {
		Car car = carService.getCar(carId);
		serviceHistory.setCar(car);
		serviceHistoryService.saveServiceHistory(serviceHistory);
		return "redirect:/car-details/" + carId;
	}

	@GetMapping("/car/{carId}/edit-service-history/{id}")
	public String editServiceHistory(@PathVariable int carId, @PathVariable Integer id, Model model) throws ParseException {
		Car car = carService.getCar(carId);
		return serviceHistoryService.addOrEdit(id, model, car);
	}

	@GetMapping("/create-service-history/{carId}")
	public String createServiceHistory(@PathVariable int carId, Model model) throws ParseException {
		Car car = carService.getCar(carId);
		return serviceHistoryService.addOrEdit(null, model, car);
	}
}
