package com.lxisoft.OnetoOneEntity.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import com.lxisoft.OnetoOneEntity.repository.QuestionRepository;

@Controller
public class ExamController {
	@Autowired
	private QuestionRepository questionRepository;
	//private AnswerRepository answerRepository;
	
	@Autowired
	public ExamController(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	/*@GetMapping(value="/")
	public String showSignUpForm(ExamModel exam) {
		return "first";
	}
	 @GetMapping(value = "/add")
	    public ModelAndView showAddPage(ModelAndView modelAndView){
	        ExamModel examModel = new  ExamModel();
	        modelAndView.addObject("exam",examModel);
	        modelAndView.setViewName("addquestion");
	        return modelAndView;
	    }*/
	 

	
}


		 
		 