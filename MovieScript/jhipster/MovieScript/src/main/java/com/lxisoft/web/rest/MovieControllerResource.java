package com.lxisoft.web.rest;

import com.lxisoft.domain.Actor;
import com.lxisoft.domain.Dialogue;
import com.lxisoft.domain.Movie;
import com.lxisoft.repository.ActorRepository;
import com.lxisoft.repository.DialogueRepository;
import com.lxisoft.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * MovieControllerResource controller
 */
@Controller
@RequestMapping("/api/movie-controller")
public class MovieControllerResource {

    private final Logger log = LoggerFactory.getLogger(MovieControllerResource.class);
    private final ActorRepository actorRepository;
    private final DialogueRepository dialogueRepository;
    private final MovieRepository movieRepository;


    @Autowired
    public MovieControllerResource(ActorRepository actorRepository, DialogueRepository dialogueRepository, MovieRepository movieRepository)
    {
        this.actorRepository = actorRepository;
        this.dialogueRepository = dialogueRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping("viewMovie")
    public String showUpdateForm(Model model) {
        model.addAttribute("actors", actorRepository.findAll());
        model.addAttribute("dialogues", dialogueRepository.findAll());
        model.addAttribute("movies", movieRepository.findAll());
        return "admin";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/adminintro")
    public void showAdminPage()
    {
       System.out.println("Working");
        System.out.println("Working");
        System.out.println("Working");
        System.out.println("Working");
        System.out.println("Working");
        System.out.println("Working");
       // return "admin-intro";
    }

    @GetMapping("/userpg")
    public void showUserPage()
    {
        System.out.println("Working");
        System.out.println("Working");
        System.out.println("Working");System.out.println("Working");
        System.out.println("Working");
        System.out.println("Working");
         //return "user";
    }

    @GetMapping("newActor")
    public String newActor(Actor actor, Model model)
    {
        model.addAttribute("movies", movieRepository.findAll());
        return "add-actor";
    }
//
//    @PostMapping("addActor")
//    public String addActor(@Valid Actor actor, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "add-actor";
//        }
//
//        actorRepository.save(actor);
//        return "redirect:adminintro";
//    }
//
//    @GetMapping("edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        Actor actor = actorRepository.findById(id)
//            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
//        model.addAttribute("actor", actor);
//        return "update-actors";
//    }
//
//    @PostMapping("update/{id}")
//    public String updateStudent(@PathVariable("id") long id, @Valid Actor actor, BindingResult result,
//                                Model model) {
//        if (result.hasErrors()) {
//            actor.setId(id);
//            return "update-student";
//        }
//
//        actorRepository.save(actor);
//        model.addAttribute("students", actorRepository.findAll());
//        return "index";
//    }
//
//    @GetMapping("newDialogue")
//    public String newDialogue(Dialogue dialogue,Model model)
//    {
//        model.addAttribute("actors", actorRepository.findAll());
//        return "add-dialogue";
//    }
//
//    @PostMapping("addDialogue")
//    public String addDialogue(@Valid Dialogue dialogue, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "add-dialogue";
//        }
//
//        dialogueRepository.save(dialogue);
//        return "redirect:adminintro";
//    }
//
//    @GetMapping("editdlg/{id}")
//    public String editDialogue(@PathVariable("id") long id, Model model) {
//        Dialogue dialogue = dialogueRepository.findById(id)
//            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
//        model.addAttribute("dialogue", dialogue);
//        return "update-dialogue";
//    }
//
//    @PostMapping("updatedlg/{id}")
//    public String updateDialogue(@PathVariable("id") long id, @Valid Dialogue dialogue, BindingResult result,
//                                 Model model) {
//        if (result.hasErrors()) {
//            dialogue.setId(id);
//            return "update-dialogue";
//        }
//
//        dialogueRepository.save(dialogue);
//        return "adminintro";
//    }
//
//    @GetMapping("deletedlg/{id}")
//    public String deletDialogue(@PathVariable("id") long id, Model model) {
//        Dialogue dialogue = dialogueRepository.findById(id)
//            .orElseThrow(() -> new IllegalArgumentException("Invalid Actor Id:" + id));
//        dialogueRepository.delete(dialogue);
//
//        return "index";
//    }
//
//    @GetMapping("newMovie")
//    public String newMovie(Movie movie)
//    {
//        return "add-movie";
//    }
//
//    @PostMapping("addmovie")
//    public String addMovie(@Valid Movie movie, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "add-movie";
//        }
//
//        movieRepository.save(movie);
//        return "redirect:adminintro";
//    }
//
//
//    @GetMapping("playmovie")
//    public String moviePlay(Model model) {
//        model.addAttribute("actors", actorRepository.findAll());
//        model.addAttribute("dialogues", dialogueRepository.findAll());
//        model.addAttribute("movies", movieRepository.findAll());
//
//        return "movie-play";
//    }

}
