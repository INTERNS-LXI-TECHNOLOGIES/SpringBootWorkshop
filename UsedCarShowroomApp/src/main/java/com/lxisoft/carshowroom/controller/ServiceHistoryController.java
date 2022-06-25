package com.lxisoft.carshowroom.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lxisoft.carshowroom.service.ServiceHistoryService;

@Controller
public class ServiceHistoryController {

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");

	@Autowired
	private ServiceHistoryService serviceHistoryService;

	@GetMapping("/car/{carId}/delete-service-history/{serviceDateStr}")
	public String deleteServiceHistory(@PathVariable int carId, @PathVariable String serviceDateStr) throws ParseException {
		Date serviceDate = dateFormat.parse(serviceDateStr);
		serviceHistoryService.deleteServiceHistory(serviceDate);
		return "redirect:/car-details/" + carId;
	}
}
