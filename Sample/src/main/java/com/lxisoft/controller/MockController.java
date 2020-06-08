package com.lxisoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.entity.*;
import com.lxisoft.service.*;

@Controller
public class MockController {
	
	@Autowired
	MockService mockService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage()
	{
		return "Home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getadministeration()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
		if(hasUserRole)
		{
			return "Admin";
		}
		else
		{
			return "Introduction";
		}
		
	}
	
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public String getUser()
	{
		return "Introduction";
	}
	
	@RequestMapping(value = "/logoutUser",method = RequestMethod.GET)
	public String userLogOut()
	{
		return "Logout";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/";  
     }
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
    public String admin() { 
        return "Admin";  
    }
	
	 @RequestMapping(value = "/displayAll")
     public ModelAndView getAllQuestions(ModelAndView model) throws IOException {
        List<MockEntity> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("View");
        return model;
    }
	 
	 @RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
     public ModelAndView newContact(ModelAndView model) {
        MockEntity mockModel = new MockEntity();
        model.addObject("mockModel", mockModel);
        model.setViewName("Add");
        return model;
    }
	 
	 @RequestMapping(value = "/add", method = RequestMethod.GET)
	 public String addQuestion(@ModelAttribute MockEntity mockModel) {
		
	            mockService.saveQuestion(mockModel);
	            return "Admin";
	            
	 }
	 
	 @RequestMapping(value = "/delete")
     public ModelAndView questionsForDelete(ModelAndView model) throws IOException {
        List<MockEntity> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("Delete");
        return model;
	 }
	 
	 @RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET)
	    public String deleteQuestion(HttpServletRequest request) {
	        int questionId = Integer.parseInt(request.getParameter("id"));
	        mockService.deleteQuestion(questionId);
	        return "Admin";
	    }
}