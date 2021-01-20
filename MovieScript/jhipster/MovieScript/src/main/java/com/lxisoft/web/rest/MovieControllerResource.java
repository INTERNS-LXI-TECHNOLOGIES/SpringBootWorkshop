package com.lxisoft.web.rest;

import com.lxisoft.domain.Actor;
import com.lxisoft.domain.Dialogue;
import com.lxisoft.domain.Movie;
import com.lxisoft.repository.ActorRepository;
import com.lxisoft.repository.DialogueRepository;
import com.lxisoft.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * MovieControllerResource controller
 */
//@RestController
//@RequestMapping("/api/movie-controller")
@Controller
public class MovieControllerResource {

    private final ActorRepository actorRepository;

    private final DialogueRepository dialogueRepository;

    private final MovieRepository movieRepository;

    private final Logger log = LoggerFactory.getLogger(MovieControllerResource.class);

    public MovieControllerResource(ActorRepository actorRepository, DialogueRepository dialogueRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.dialogueRepository = dialogueRepository;
        this.movieRepository = movieRepository;
    }

    /**
    * GET add
    */

    @GetMapping("/home")
    public String login()
    {
        return "index";
    }

    @GetMapping("viewMovie")
    public String showUpdateForm(Model model) {
        model.addAttribute("actors", actorRepository.findAll());
        model.addAttribute("dialogues", dialogueRepository.findAll());
        model.addAttribute("movies", movieRepository.findAll());
        return "admin";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "/login";
//    }

    @GetMapping("adminintro")
    public String showAdminPage()
    {
        return "admin-intro";
    }

    @GetMapping("userpg")
    public String showUserPage()
    {
        return "user";
    }

    @GetMapping("newActor")
    public String newActor(Actor actor,Model model)
    {
        model.addAttribute("movies", movieRepository.findAll());
        return "add-actor";
    }

    @PostMapping("addActor")
    public String addActor(@Valid Actor actor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-actor";
        }

        actorRepository.save(actor);
        return "redirect:admin-intro";
    }

    @GetMapping("editactor/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Actor actor = actorRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("actor", actor);
        return "update-actors";
    }

    @PostMapping("updateactor/{id}")
    public String updateActor(@PathVariable("id") long id, @Valid Actor actor, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            actor.setId(id);
            return "update-actors";
        }

        actorRepository.save(actor);
        return "admin-intro";
    }

    @GetMapping("deleteactor/{id}")
    public String deleteActor(@PathVariable("id") long id, Model model) {
        Actor actor = actorRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid Actor Id:" + id));
        actorRepository.delete(actor);

        return "admin-intro";
    }

    @GetMapping("newDialogue")
    public String newDialogue(Dialogue dialogue,Model model)
    {
        model.addAttribute("dialogues", dialogueRepository.findAll());
        return "add-dialogue";
    }

    @PostMapping("addDialogue")
    public String addDialogue(@Valid Dialogue dialogue, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-dialogue";
        }

        dialogueRepository.save(dialogue);
        return "redirect:admin-intro";
    }

    @GetMapping("editdlg/{id}")
    public String editDialogue(@PathVariable("id") long id, Model model) {
        Dialogue dialogue = dialogueRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("dialogue", dialogue);
        return "update-dialogue";
    }

    @PostMapping("updatedlg/{id}")
    public String updateDialogue(@PathVariable("id") long id, @Valid Dialogue dialogue, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            dialogue.setId(id);
            return "update-dialogue";
        }

        dialogueRepository.save(dialogue);
        return "admin-intro";
    }

    @GetMapping("deletedlg/{id}")
    public String deletDialogue(@PathVariable("id") long id, Model model) {
        Dialogue dialogue = dialogueRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid Actor Id:" + id));
        dialogueRepository.delete(dialogue);

        return "admin-intro";
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
        return "redirect:adminintro";
    }
    @GetMapping("editmovie/{id}")
    public String editmovie(@PathVariable("id") long id, Model model) {
        Movie movie = movieRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("movie", movie);
        return "update-movie";
    }

    @PostMapping("updatemovie/{id}")
    public String updateMovie(@PathVariable("id") long id, @Valid Movie movie, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            movie.setId(id);
            return "update-movie";
        }

        movieRepository.save(movie);
        return "admin-intro";
    }


    @GetMapping("playmovie")
    public String moviePlay(Model model) {
        model.addAttribute("actors", actorRepository.findAll());
        model.addAttribute("dialogues", dialogueRepository.findAll());
        model.addAttribute("movies", movieRepository.findAll());

        return "movie-play";
    }


}
