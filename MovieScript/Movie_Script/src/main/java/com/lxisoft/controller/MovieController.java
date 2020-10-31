package com.lxisoft.controller;

import com.lxisoft.entity.Actor;
import com.lxisoft.entity.Dialogue;
import com.lxisoft.entity.Movie;
import com.lxisoft.repository.ActorRepository;
import com.lxisoft.repository.DialogueRepository;
import com.lxisoft.repository.MovieRepository;
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

	private final MovieRepository movieRepository;


	@Autowired
	public MovieController(ActorRepository actorRepository, DialogueRepository dialogueRepository, MovieRepository movieRepository)
	{
		this.actorRepository = actorRepository;
		this.dialogueRepository = dialogueRepository;
		this.movieRepository = movieRepository;
	}

//	@GetMapping("adminpg")
//	public String showAdminPage()
//	{
//		return "admin";
//	}
	@GetMapping("adminpg")
	public String showUpdateForm(Model model) {
		model.addAttribute("actors", actorRepository.findAll());
		model.addAttribute("dialogues", dialogueRepository.findAll());
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

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("actor", actor);
		return "update-actors";
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

	@GetMapping("editdlg/{id}")
	public String editDialogue(@PathVariable("id") int id, Model model) {
		Dialogue dialogue = dialogueRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("dialogue", dialogue);
		return "update-dialogue";
	}

	@PostMapping("updatedlg/{id}")
	public String updateDialogue(@PathVariable("id") int id, @Valid Dialogue dialogue, BindingResult result,
								Model model) {
		if (result.hasErrors()) {
			dialogue.setId(id);
			return "update-dialogue";
		}

		dialogueRepository.save(dialogue);
		return "adminpg";
	}

	@GetMapping("newMovie")
	public String newMovie(Movie movie)
	{
		return "add-movie";
	}

	@PostMapping("addmovie")
	public String addMovie(@Valid Movie movie, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-movie";
		}

		movieRepository.save(movie);
		return "redirect:adminpg";
	}


	@GetMapping("playmovie")
	public String moviePlay(Model model) {
		model.addAttribute("actors", actorRepository.findAll());
		model.addAttribute("dialogues", dialogueRepository.findAll());
		model.addAttribute("movies", movieRepository.findAll());

		return "movie-play";
	}



}