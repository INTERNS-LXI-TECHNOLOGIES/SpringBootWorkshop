package com.lxisoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{

	@RequestMapping("/home")
	public String homePage()
	{
		return "homepage";
	}
	@RequestMapping("/addMovie")
	public String addMovie()
	{
		return "addMovie";
	}
}
