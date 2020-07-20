package com.lxisoft.sample.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Controller
public class Controller {
	@Autowired
	private MockExamService mockExamService;
	
	  
	 public Controller()
	    {
	        
	    }
	@GetMapping("/login")
	public String login(Model model)
	{
		return "login";
	}
	
	
    
    @GetMapping("/addPost")
    public ModelAndView post()
    {
        
        model.setViewName("addPost");
        return model;
    }
    
    @PostMapping(value = "/add")
    public ModelAndView sendPost()
    {
        
       
        return new ModelAndView("redirect:/home");
    }
    
    
}
