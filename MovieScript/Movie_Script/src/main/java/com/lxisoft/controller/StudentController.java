package com.lxisoft.controller;

import javax.validation.Valid;

import com.lxisoft.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxisoft.entity.Actor;

@Controller
//@RequestMapping("/actors/")
public class StudentController {

	private final ActorRepository actorRepository;

	@Autowired
	public StudentController(ActorRepository actorRepository)
	{
		this.actorRepository = actorRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Actor actor)
	{
		return "add-student";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("actors", actorRepository.findAll());
		return "index";
	}

	@PostMapping("add")
	public String addActor(@Valid Actor actor, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-student";
		}

		actorRepository.save(actor);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("actor", actor);
		return "update-student";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @Valid Actor actor, BindingResult result,
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
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		actorRepository.delete(actor);
		model.addAttribute("students", actorRepository.findAll());
		return "index";
	}
}
