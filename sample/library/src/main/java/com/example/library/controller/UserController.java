package com.example.library.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.library.dto.UserDto;
import com.example.library.service.UserService;
@Controller
@RequestMapping("/addUsers")
public class UserController {

	private UserService userService;

	public UserController()
	{

	}

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
		
	@ModelAttribute("user")
	public UserDto userDto() {
		return new UserDto();
	}
	
	@GetMapping
	public String showAddForm() {
		
			return "addUser";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user")UserDto userDto){
		userService.addUser(userDto);
		return "redirect:/registration?success";
	}
}
