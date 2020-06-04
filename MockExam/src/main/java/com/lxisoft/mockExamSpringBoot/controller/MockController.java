package com.lxisoft.mockExamSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.lxisoft.mockExamSpringBoot.entity.MockEntity;
import com.lxisoft.mockExamSpringBoot.service.*;
@Controller
public class MockController {
	
	@Autowired
	private MockService mockService;
	
	@GetMapping("/")
	public String homeView(){
		return "home";
	}
	
	@GetMapping("/admin")
	public String adminView() {
		return "Admin";
	}
	
	 @GetMapping("/testAdmin")
	 public ModelAndView viewAllQuestion(ModelAndView model) {
		 List<MockEntity> listQuestions = mockService.getAllQuestions();
		 model.addObject("listQuestions", listQuestions);
	     model.setViewName("Admin1");
		 return model;
	 }
	
	@GetMapping("/user")
	public String userView() {
		return "Introduction";
	}
	
	@GetMapping("/startExam")
	public ModelAndView startExam(ModelAndView model) {
		List<MockEntity> listQuestions = mockService.getAllQuestions();
		 model.addObject("listQuestions", listQuestions.get(0));
	     model.setViewName("Exam");
		return model;
	}
		
	 @GetMapping("/addQuestion")
     public ModelAndView addNewQuestion(ModelAndView model) {
        MockEntity mockEntity = new MockEntity();
        model.addObject("mockEntity", mockEntity);
        model.setViewName("Add");
        return model;
    }

	 @GetMapping("/add")
	 public String addQuestion(@ModelAttribute MockEntity mockEntity) {
			 mockService.saveQuestion(mockEntity);
		 return "redirect:/testAdmin";
	 }
	 
	 @GetMapping("/getAllQuestion")
	 public ModelAndView getAllQuestion(ModelAndView model) {
		 List<MockEntity> listQuestions = mockService.getAllQuestions();
		 model.addObject("listQuestions", listQuestions);
	     model.setViewName("View");
		 return model;
	 }
	 
	 @GetMapping("/delete")
	 public ModelAndView deleteQuestion(ModelAndView model) {
		 List<MockEntity> listQuestions = mockService.getAllQuestions();
		 model.addObject("listQuestions", listQuestions);
	     model.setViewName("Delete");
		 return model;
	 }
	 
	 @GetMapping("/deleteQuestion/{id}")
	    public String deleteQuestion(@PathVariable("id") int id) {
			    mockService.deleteQuestion(id);
	        return "redirect:/testAdmin";
	    }
	 
	 @GetMapping("/updateQuestion/{id}")
	 public ModelAndView updateQuestion(@PathVariable("id") int id) {
		 Optional<MockEntity> mockEntity = mockService.getQuestionId(id);
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.addObject("mockEntity",mockEntity);
		 modelAndView.setViewName("Update");
		 return modelAndView;
	 }
	 
	 @GetMapping("/update")
	 public String updateQuestion(@ModelAttribute MockEntity mockEntity) {
		 mockService.saveQuestion(mockEntity);
		 return "redirect:/testAdmin"; 
	 }
	 
}
