package com.lxisoft.OnetoOneEntity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.OnetoOneEntity.entity.Answer;
import com.lxisoft.OnetoOneEntity.entity.Question;
import com.lxisoft.OnetoOneEntity.model.ExamModel;
import com.lxisoft.OnetoOneEntity.repository.AnswerRepository;
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
	 @GetMapping(value = "/addNewQuestion")
	    public String addQuestion(@ModelAttribute ExamModel examModel){
	       Question question=new Question();
	       question.setQuestion(examModel.getQuestion());
	       Answer answer=new Answer();
	       answer.setAnswer(examModel.getAnswer());
	       question.setAnswer(answer);
	       questionRepository.save(question);
	        return "first";
	    }

	
}


		 
		 