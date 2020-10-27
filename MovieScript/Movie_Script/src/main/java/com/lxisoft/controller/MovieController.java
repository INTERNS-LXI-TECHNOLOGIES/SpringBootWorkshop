package com.lxisoft.controller;

import com.lxisoft.entity.Actor;
import com.lxisoft.entity.Dialogue;
import com.lxisoft.repository.ActorRepository;
import com.lxisoft.repository.DialogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
//@RequestMapping("/actors/")
public class MovieController {

	private final ActorRepository actorRepository;

	private final DialogueRepository dialogueRepository;

	@Autowired
	public MovieController(ActorRepository actorRepository, DialogueRepository dialogueRepository)
	{
		this.actorRepository = actorRepository;
		this.dialogueRepository = dialogueRepository;
	}

//	@GetMapping("adminpg")
//	public String showAdminPage()
//	{
//		return "admin";
//	}
	@GetMapping("adminpg")
	public String showUpdateForm(Model model) {
		model.addAttribute("actors", actorRepository.findAll());
		return "admin";
	}

	@GetMapping("userpg")
	public String showUserPage()
	{
		return "user";
	}

	@GetMapping("newActor")
	public String newActor(Actor actor)
	{
		return "add-actor";
	}

	@PostMapping("addActor")
	public String addActor(@Valid Actor actor, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-actor";
		}

		actorRepository.save(actor);
		return "redirect:adminpg";
	}

	@GetMapping("newDialogue")
	public String newDialogue(Dialogue dialogue)
	{
		return "add-dialogue";
	}

	@PostMapping("addDialogue")
	public String addDialogue(@Valid Dialogue dialogue, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-dialogue";
		}

		dialogueRepository.save(dialogue);
		return "redirect:adminpg";
	}

}