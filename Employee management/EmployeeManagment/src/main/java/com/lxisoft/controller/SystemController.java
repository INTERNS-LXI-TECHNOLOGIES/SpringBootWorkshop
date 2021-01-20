package com.lxisoft.controller;

import com.lxisoft.entity.Store;
import com.lxisoft.entity.User;
import com.lxisoft.repository.StoreRepository;
import com.lxisoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller

public class SystemController {

	private final UserRepository userRepository;

	private final StoreRepository storeRepository;

	@Autowired
	public SystemController(UserRepository userRepository,StoreRepository storeRepository)
	{
		this.userRepository = userRepository;
		this.storeRepository=storeRepository;

	}
	@GetMapping("/")
	public String root() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@GetMapping("adminintro")
	public String showAdminPage()
	{
		return "admin-intro";
	}

	@GetMapping("viewTable")
	public String ownerDetails(Model model)
	{
		model.addAttribute("users",userRepository.findAll());
		return "userTable";
	}


	@GetMapping("addEmploye")
	public String addUser(User user,Model model)
	{		return "add-user";	}

	@PostMapping("newUser")
	public String newUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}

		userRepository.save(user);
		return "redirect:userIntro";
	}

	@GetMapping("addStore")
	public String addStore(Store store, Model model)
	{		return "add-store";	}

	@PostMapping("newStore")
	public String newStore(@Valid Store store, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-store";
		}

		storeRepository.save(store);
		return "redirect:index";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));
		model.addAttribute("user", user);
		return "update-user";
	}

	@PostMapping("update/{id}")
	public String rupdateRoom(@PathVariable("id") long id, @Valid User user, BindingResult result,
							  Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}

		userRepository.save(user);

		return "viewTable";
	}


}