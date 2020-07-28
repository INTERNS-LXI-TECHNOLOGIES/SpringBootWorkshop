package com.lxisoft.MockexamProject.web;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.MockexamProject.entity.AnsOption;
import com.lxisoft.MockexamProject.entity.Answer;
import com.lxisoft.MockexamProject.entity.Question;
import com.lxisoft.MockexamProject.model.ExamModel;
import com.lxisoft.MockexamProject.repository.QuestionRepository;



@Controller
public class MainController {
	@Autowired
    private QuestionRepository questionRepository;
	
    @GetMapping("/")
    public String root() {
        return "first";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "first";
    }
    
    @RequestMapping(value = "/newquestion", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        ExamModel exam = new ExamModel();
        model.addObject("exam", exam);
        model.setViewName("add");
        return model;
    }
    @GetMapping(value = "/add")
    public String addNewQuestion(@ModelAttribute ExamModel exam){
    	List<AnsOption> qnOptions = new ArrayList<>();
        Question question = exam.getQuestion();
        Answer answer = exam.getAnswer();
        answer.setQuestion(question);
        question.setAnswer(answer);
        
        AnsOption option1 = new AnsOption();
        AnsOption option2 = new AnsOption();
        AnsOption option3 = new AnsOption();
        AnsOption option4 = new AnsOption();
        
       
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
}