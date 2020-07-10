package com.lxisoft.OnetoOneEntity.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.OnetoOneEntity.model.ExamModel;
import com.lxisoft.OnetoOneEntity.repository.QuestionRepository;

@Controller
public class ExamController {
	@Autowired
	private QuestionRepository questionRepository;
	
	
	@Autowired
	public ExamController(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	@GetMapping(value="/")
	public String showSignUpForm(ExamModel exam) {
		return "first";
	}
	 @GetMapping(value = "/add")
	    public ModelAndView showAddPage(ModelAndView modelAndView){
	        ExamModel examModel = new  ExamModel();
	        modelAndView.addObject("exam",examModel);
	        modelAndView.setViewName("addquestion");
	        return modelAndView;
	    }
	 

	
}


		 
		 