package com.lxisoft.controller;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.jboss.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.entity.MockEntity;
import com.lxisoft.service.MockService;

@Controller
public class MockController 
{
	public MockController() 
	{
        System.out.println("MockController()");
    }
	

	@RequestMapping(value={ "/", "/welcome**"}, method = RequestMethod.GET)
	public String home(Map<String, Object> model) {
      model.addObject("title", "LOGIN");
	  model.addObject("message", "login for yor Authentication");
	  model.setViewName("hello");
        return model;
		
	}

	@Autowired
	private MockService mockService;
	/*private static final Logger logger = Logger.getLogger(MockController.class);*/
   
   
	
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView getAdmin(ModelAndView model)
	{
	  model.addObject("title", "Admin");
	  model.setViewName("Admin");
	  return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully");
	  }
	  model.setViewName("login");

	  return model;

	}

}