package com.lxisoft.OnetoOneEntity.controller;

import java.util.ArrayList;

import java.util.List;

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

import com.lxisoft.OnetoOneEntity.entity.AnsOption;
import com.lxisoft.OnetoOneEntity.entity.Answer;
import com.lxisoft.OnetoOneEntity.entity.Question;
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
	 @GetMapping(value = "/addNewQuestion")
	 public String addNewQuestion(@ModelAttribute ExamModel examModel){
	    	List<AnsOption> ansOptions = new ArrayList<>();
	      
	        
	    	   Question question=new Question();
		       question.setQuestion(examModel.getQuestion());
		       Answer answer=new Answer();
		       answer.setAnswer(examModel.getAnswer());
		       answer.setQuestion(question);
		       question.setAnswer(answer);
		       
		       
		     
	        AnsOption option1 = new AnsOption();
	        AnsOption option2 = new AnsOption();
	        AnsOption option3 = new AnsOption();
	        AnsOption option4 = new AnsOption();
	        
	       
	        option1.setAnsOption(examModel.getOption1());
	        option2.setAnsOption(examModel.getOption2());
	        option3.setAnsOption(examModel.getOption3());
	        option4.setAnsOption(examModel.getOption4());

	        option1.setQuestion(question);
	        option2.setQuestion(question);
	        option3.setQuestion(question);
	        option4.setQuestion(question);

	        ansOptions.add(option1);
	        ansOptions.add(option2);
	        ansOptions.add(option3);
	        ansOptions.add(option4);

	        question.setOptions(ansOptions);
	        
	        questionRepository.save(question);
	        return "first";
	    }
	 
	 @RequestMapping(value = "/findAllQuestions")
	    public ModelAndView showAllQ()
	    {
	        List<Question> questionList = questionRepository.findAll();
	        ModelAndView model = new ModelAndView();
	        model.addObject("show",questionList);
	        model.setViewName("viewExam");
	        return model;
	    }

	 @RequestMapping("update/{id}") 
	 public String updateExam(@PathVariable("id")
	 long id, Question question, BindingResult result, Model model) { if
	 (result.hasErrors()) { question.setId(id); return "update-exam"; }
	 
	 questionRepository.save(question); model.addAttribute("questions",
	 questionRepository.findAll()); return "first"; }
	 
	 @GetMapping("delete/{id}")
		public String deleteQuestion(@PathVariable("id") long id, Model model) {
			Question question = questionRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Invalid exam Id:" + id));
			questionRepository.delete(question);
			model.addAttribute("exams", questionRepository.findAll());
			return "first";
	
	 }
}


		 
		 