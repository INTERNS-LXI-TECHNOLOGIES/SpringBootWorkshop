package com.lxisoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.repository.MovieRepo;

@RestController
public class Controller 
{
	@Autowired
	MovieRepo mRepo;

	@RequestMapping("/home")
	public String homePage()
	{
		return "homepage";
	}
	@RequestMapping("/addMovie")
	public String addMovie(Movie mov)
	{
		mRepo.save();
		return "home";
	}
}
