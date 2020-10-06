package com.lxisoft.moviescript.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller 
{
	//@Autowired
	//Service service ;
	

	@GetMapping("/")
	public String homePage()
	{
		System.out.println("Asdad");
		return "homepage";
	}
//	@RequestMapping("/addMovie")
//	public String addMovie(Movie mov)
//	{
//		service.saveMovie(mov);
//		return "home";
//	}
}
