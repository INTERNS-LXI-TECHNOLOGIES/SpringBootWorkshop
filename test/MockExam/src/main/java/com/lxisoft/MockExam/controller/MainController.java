package com.lxisoft.MockExam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxisoft.MockExam.model.Question;
import com.lxisoft.MockExam.service.AnswerService;
import com.lxisoft.MockExam.service.MockExamService;
import com.lxisoft.MockExam.service.OptionService;
import com.lxisoft.MockExam.service.QuestionService;
import com.lxisoft.MockExam.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
@Controller
public class MainController {
	@Autowired
	private MockExamService mockExamService;
	
	  	private QuestionService questionService;
	    private AnswerService answerService;
	    private OptionService optionService;
	    private UserService userService;
		/* private RoleService roleService; */
	
	 public MainController(QuestionService questionService, AnswerService answerService, OptionService optionService,UserService userService)
	    {
	        this.questionService = questionService;
	        this.answerService = answerService;
	        this.optionService = optionService;
	        this.userService = userService;
	    }
	
	
	@GetMapping("/login")
	public String login(Model model)
	{
		return "login";
	}
	
	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("listQuestions",mockExamService.getAllQuestions());
		return "admin";
	}

	 @GetMapping("/user")
    public String userIndex() {
        return "user";
    }

	@GetMapping("/logout")
    public String logout(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";
    }

    @RequestMapping(value = "/back")
    public String backTo()
    {
        return "login";
    }

    @RequestMapping(value = "/admin")
    public String adminView(Model model)
    {
    	model.addAttribute("listQuestions",mockExamService.getAllQuestions());
        return "admin";
    }

    @GetMapping("/addNewQuestion")
    public String addnewQuestion(Model model) {
    	Question question=new Question();
    	model.addAttribute("question",question);
    	return "addQuestion";
    }
    
    @PostMapping("/saveQuestion")
    public String saveQuestion(@ModelAttribute("question") Question question) {
    	mockExamService.save(question);
    	return "redirect:/";
    }  
}
