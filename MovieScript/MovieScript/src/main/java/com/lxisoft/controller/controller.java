package com.lxisoft.controller;
import com.lxisoft.model.Actor;
import com.lxisoft.model.Dialogue;
import com.lxisoft.model.User;
import com.lxisoft.service.ActorService;
import com.lxisoft.service.DialogueService;
import com.lxisoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class controller
{
//    @Autowired
//    private UserService userService;

    @Autowired
    private ActorService actorService;

    @Autowired
    private DialogueService dialogueService;

    @GetMapping(value = {"/", "/home"})
    public String indexPage() {
        return "index";
    }

    @GetMapping(value = {"/adminpage"})
    public String adminPage() {
        return "admin";
    }

//    @GetMapping(value = "/adminpage")
//    public ModelAndView adminView(HttpServletRequest request, HttpServletResponse response)
//    {
//        HttpSession session = request.getSession();
//        List<Actor> actorList = actorService.getAllActors();
//        session.setAttribute("actList",actorList);
//        ModelAndView model = new ModelAndView();
//        model.addObject("Actorlist",actorList);
//        model.setViewName("admin");
//        return model;
//    }

    @RequestMapping(value = "/new" ,method= RequestMethod.GET)
    public ModelAndView addUser(ModelAndView model)
    {

        User user = new User();
        model.addObject("user",user);
        model.setViewName("newUser");
        return model;
    }

//    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
//    public ModelAndView saveUser(@ModelAttribute User user)
//    {
//        userService.saveUser(user);
//        return new ModelAndView("redirect:/home");
//    }
//
//    @RequestMapping(value="/deleteuser")
//    public ModelAndView deleteUser(HttpServletRequest request)
//    {
//        int userid = Integer.parseInt(request.getParameter("id"));
//        userService.deleteUser(userid);
//        return new ModelAndView("redirect:/admin");
//
//    }



    @RequestMapping(value = "/newActor" ,method= RequestMethod.GET)
    public ModelAndView addActor(ModelAndView model)
    {

        Actor actor = new Actor();
        model.addObject("actor",actor);
        model.setViewName("addActor");
        return model;
    }

    @RequestMapping(value = "/saveActor",method = RequestMethod.GET)
    public ModelAndView saveActor(@ModelAttribute Actor actor)
    {
        actorService.saveActor(actor);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value="/deleteActor")
    public ModelAndView deleteActor(HttpServletRequest request)
    {
        int actorid = Integer.parseInt(request.getParameter("id"));
        actorService.deleteActor(actorid);
        return new ModelAndView("redirect:/admin");

    }

    @RequestMapping(value = "/newDialogue" ,method= RequestMethod.GET)
    public ModelAndView addDialogue(ModelAndView model)
    {

        Dialogue dialogue = new Dialogue();
        model.addObject("dialogue",dialogue);
        model.setViewName("addDialogue");
        return model;
    }

    @RequestMapping(value = "/saveDialogue",method = RequestMethod.GET)
    public ModelAndView saveDialogue(@ModelAttribute Dialogue dialogue)
    {
        dialogueService.saveDialogue(dialogue);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value="/deleteDialogue")
    public ModelAndView deleteDialogue(HttpServletRequest request)
    {
        int dilgid = Integer.parseInt(request.getParameter("id"));
        dialogueService.deleteDialogue(dilgid);
        return new ModelAndView("redirect:/admin");

    }

}
