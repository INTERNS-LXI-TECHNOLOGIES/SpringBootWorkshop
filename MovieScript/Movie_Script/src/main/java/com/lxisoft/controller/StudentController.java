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
public class StudentController {

	private final ActorRepository actorRepository;

	private final DialogueRepository dialogueRepository;

	@Autowired
	public StudentController(ActorRepository actorRepository, DialogueRepository dialogueRepository)
	{
		this.actorRepository = actorRepository;
		this.dialogueRepository = dialogueRepository;
	}

	@GetMapping("adminpg")
	public String showAdminPage()
	{
		return "admin";
	}

	@GetMapping("userpg")
	public String showUserPage()
	{
		return "user";
	}

	@GetMapping("newActor")
	public String showSignUpForm(Actor actor)
	{
		return "add-actor";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("actors", actorRepository.findAll());
		return "index";
	}

	@PostMapping("addActor")
	public String addActor(@Valid Actor actor, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-actor";
		}

		actorRepository.save(actor);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("actor", actor);
		return "update-student";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") int id, @Valid Actor actor, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			actor.setId(id);
			return "update-student";
		}

		actorRepository.save(actor);
		model.addAttribute("students", actorRepository.findAll());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") int id, Model model) {
		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Actor Id:" + id));
		actorRepository.delete(actor);
		model.addAttribute("actors", actorRepository.findAll());
		return "index";
	}

	@GetMapping("addDialogue")
	public String showDialogueForm(Dialogue dialogue)
	{
		return "add-Dialogue";
	}

	@PostMapping("addDlg")
	public String addDialogue(@Valid Dialogue dialogue, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-dialogue";
		}

		dialogueRepository.save(dialogue);
		return "redirect:index";
	}
}