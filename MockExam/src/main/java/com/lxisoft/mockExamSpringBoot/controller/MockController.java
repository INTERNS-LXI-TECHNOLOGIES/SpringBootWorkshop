package com.lxisoft.mockExamSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.lxisoft.mockExamSpringBoot.entity.MockEntity;
import com.lxisoft.mockExamSpringBoot.service.*;
@Controller
public class MockController {
	
	@Autowired
	private MockService mockService;
	
	private int testVariable = 0;
	
	@GetMapping("/")
	public String homeView(){
		return "home";
	}
	
	 @GetMapping("/testAdmin")
	 public ModelAndView viewAllQuestion(ModelAndView model) {
		 List<MockEntity> listQuestions = mockService.getAllQuestions();
		 model.addObject("listQuestions", listQuestions);
	     model.setViewName("Admin1");
		 return model;
	 }
	
//	@GetMapping("/user")
//	public String userView() {
//		return "Introduction";
//	}
	
	@GetMapping("/user")
	public String setQuestionsSession(HttpServletRequest request) {
		HttpSession sessions = request.getSession(true);
		List<MockEntity> listQuestions = mockService.getAllQuestions();
		sessions.setAttribute("listQuestions", listQuestions);
		return "Introduction";
	}
	
	@GetMapping("/startExam")
	public ModelAndView startExam(HttpServletRequest request) {
		HttpSession sessions = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<MockEntity> listQuestions = (List<MockEntity>)sessions.getAttribute("listQuestions");
		ModelAndView model = new ModelAndView();
		if(testVariable < listQuestions.size()) {
			model.addObject("listQuestions", listQuestions.get(testVariable));
			testVariable++;
		    model.setViewName("Exam");
		}
		else {
			testVariable=0;
			model.setViewName("redirect:/result");
		}
		return model;
	}
	
	@GetMapping("/selectedOption")
	public String selectedOption(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<MockEntity> listQuestions = (List<MockEntity>)session.getAttribute("listQuestions");
		int selectedOption = 0;
		  if(request.getParameter("option")!= null)
		  {
			   selectedOption =  Integer.parseInt(request.getParameter("option"));
		  }
		  
		  switch(selectedOption)
		  {
		  case 1 :
			  listQuestions.get(testVariable-1).setSelectedOption(listQuestions.get(testVariable-1).getOption1());
			  break;
		  case 2 :
			  listQuestions.get(testVariable-1).setSelectedOption(listQuestions.get(testVariable-1).getOption2());
			  break;
		  case 3 :
			  listQuestions.get(testVariable-1).setSelectedOption(listQuestions.get(testVariable-1).getOption3());
			  break;
		  case 4 :
			  listQuestions.get(testVariable-1).setSelectedOption(listQuestions.get(testVariable-1).getOption4());
			  break;
		  default :
			  listQuestions.get(testVariable-1).setSelectedOption("");
			  break;
		  }
		  
		  session.setAttribute("listQuestions", listQuestions);
			
		return "redirect:/startExam";
	}
	
	@GetMapping("/result")
	public ModelAndView calculateResult(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<MockEntity> listQuestions = (List<MockEntity>)session.getAttribute("listQuestions");
		int mark = 0;
		Iterator<MockEntity> list = listQuestions.iterator();
		while(list.hasNext()) {
			MockEntity mockEntity = (MockEntity)list.next();
			if(mockEntity.getAnswer().equals(mockEntity.getSelectedOption()))
				mark++;
		}
		ModelAndView model = new ModelAndView();
		model.addObject("result", mark);
		model.addObject("listQuestions",listQuestions);
		model.setViewName("Result");
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
