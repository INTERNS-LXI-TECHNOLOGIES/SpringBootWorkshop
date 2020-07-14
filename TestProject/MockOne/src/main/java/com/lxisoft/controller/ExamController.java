package com.lxisoft.controller;

import com.lxisoft.entity.Answer;
import com.lxisoft.entity.Question;
import com.lxisoft.entity.QnOption;
import com.lxisoft.model.Exam;
import com.lxisoft.repository.AnswerRepository;
import com.lxisoft.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


@Controller
public class ExamController {

    @Autowired
    private QuestionRepository questionRepository;
    

    @RequestMapping(value="/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "index";
    }

    @RequestMapping(value = "/newquestion", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Exam exam = new Exam();
        model.addObject("exam", exam);
        model.setViewName("add");
        return model;
    }
    
    @GetMapping(value = "/add")
    public String addNewQuestion(@ModelAttribute Exam exam){
    	List<QnOption> qnOptions = new ArrayList<>();
        Question question = exam.getQuestion();
        Answer answer = exam.getAnswer();
        answer.setQuestion(question);
        question.setAnswer(answer);
        
        QnOption option1 = new QnOption();
        QnOption option2 = new QnOption();
        QnOption option3 = new QnOption();
        QnOption option4 = new QnOption();
        
       
        option1.setQOption(exam.getOption1());
        option2.setQOption(exam.getOption2());
        option3.setQOption(exam.getOption3());
        option4.setQOption(exam.getOption4());

        option1.setQuestion(question);
        option2.setQuestion(question);
        option3.setQuestion(question);
        option4.setQuestion(question);

        qnOptions.add(option1);
        qnOptions.add(option2);
        qnOptions.add(option3);
        qnOptions.add(option4);

        question.setOptions(qnOptions);
        
        questionRepository.save(question);
        return "index";
    }
    
    @GetMapping(value = "/viewAll")
    public ModelAndView listExam(ModelAndView model) throws IOException {
        List<Question> listExam = questionRepository.findAll();
        model.addObject("listExam", listExam);
        model.setViewName("read");
        return model;
    }
    
    
    @GetMapping(value = "/delete/{id}")
    public String deleteQuest(@PathVariable("id") int id) {
    	long examId = (long)id;
    	questionRepository.deleteById(examId);
    	return "read";   
  }
    
    
    @GetMapping(value = "/update/{id}")
	public String updateStudent(@PathVariable("id") long id,  Question question, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			question.setId(id);
			return "update";
		}

		questionRepository.save(question);
		model.addAttribute("exams", questionRepository.findAll());
		return "read";
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}