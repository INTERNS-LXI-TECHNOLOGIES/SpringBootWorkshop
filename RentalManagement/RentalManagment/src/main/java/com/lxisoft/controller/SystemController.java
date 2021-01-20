package com.lxisoft.controller;

import com.lxisoft.entity.Room;
import com.lxisoft.entity.User;
import com.lxisoft.repository.RoomRepository;
import com.lxisoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

public class SystemController {

	private final UserRepository userRepository;
	private final RoomRepository roomRepository;


	@Autowired
	public SystemController(UserRepository userRepository,RoomRepository roomRepository)
	{
		this.userRepository = userRepository;
		this.roomRepository=roomRepository;

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

	@GetMapping("roomdetails")
	public String roomDetails(Model model)
	{
		model.addAttribute("rooms",roomRepository.findAll());
		return "roomdetails";
	}


	@GetMapping("addUser")
	public String addUser(User user,Model model)
	{

		return "add-user";
	}

	@PostMapping("newUser")
	public String newUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}

		userRepository.save(user);
		return "redirect:userIntro";
	}

	@GetMapping("userview")
	public String moviePlay(Model model) {
		model.addAttribute("rooms",roomRepository.findAll());
			return "userIntro";
	}


	@GetMapping("newRoom")
	public String newRoom(Room room)
	{
		return "add-room";
	}

	@PostMapping("addRoom")
	public String addRoom(@Valid Room room, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-room";
		}

		roomRepository.save(room);
		return "redirect:adminintro";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Room room = roomRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));
		model.addAttribute("room", room);
		return "update-room";
	}

	@PostMapping("update/{id}")
	public String rupdateRoom(@PathVariable("id") long id, @Valid Room room, BindingResult result,
								Model model) {
		if (result.hasErrors()) {
			room.setId(id);
			return "update-student";
		}

		roomRepository.save(room);

		return "adminintro";
	}


	@GetMapping("deleteroom/{id}")
	public String deletDialogue(@PathVariable("id") long id, Model model) {
		Room room = roomRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Room Id:" + id));
		roomRepository.delete(room);

		return "adminintro";
	}

	@GetMapping("booking/{id}")
	public String bookingRoom(@PathVariable("id") long id, Model model) {
		Room room = roomRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));
		room.setBooking(Boolean.TRUE);
		roomRepository.save(room);
		return "index";

	}

	@GetMapping("cancel/{id}")
	public String cancelBooling(@PathVariable("id") long id, Model model) {
		Room room = roomRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));
		room.setBooking(Boolean.FALSE);
		roomRepository.save(room);
		return "index";

	}



}