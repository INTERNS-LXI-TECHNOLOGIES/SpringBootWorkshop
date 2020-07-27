package com.lxisoft.MockExam.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.lxisoft.MockExam.model.Answer;
import com.lxisoft.MockExam.model.MockQuestion;
import com.lxisoft.MockExam.model.Options;
import com.lxisoft.MockExam.model.Question;
import com.lxisoft.MockExam.service.AnswerService;
import com.lxisoft.MockExam.service.MockExamService;
import com.lxisoft.MockExam.service.OptionService;
import com.lxisoft.MockExam.service.QuestionService;
import com.lxisoft.MockExam.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Controller
public class MainController {
	@Autowired
	private MockExamService mockExamService;
	
	  	private QuestionService questionService;
	    private AnswerService answerService;
	    private OptionService optionService;
	    private UserService userService;
	
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
	@GetMapping("/admin")
	public ModelAndView home()
	{
        MockQuestion mockExam = new MockQuestion();
        ModelAndView model = new ModelAndView();
        List<Question> question= questionService.getAll();
		model.addObject("listQuestions",question);
        model.setViewName("admin");
		return model;
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
    
    @GetMapping("/addQuest")
    public ModelAndView get()
    {
        MockQuestion mockExam = new MockQuestion();
        ModelAndView model = new ModelAndView();
        model.addObject("mockExam",mockExam);
        model.setViewName("addQuestion");
        return model;
    }
    
    @PostMapping(value = "/add")
    public ModelAndView mockData(@ModelAttribute("mockExam") MockQuestion mockExam)
    {
        
        Question question = mockExam.getQuestion();
        Answer answer = mockExam.getAnswer();
        question.setAnswer(answer);
        List<Options> options = new ArrayList<Options>();   
        Options option1 = new Options();
        Options option2 = new Options();
        Options option3 = new Options();
   
        option1.setOption(mockExam.getOption1());
        option2.setOption(mockExam.getOption2());
        option3.setOption(mockExam.getOption3());
      
        option1.setQuestion(question);
        option2.setQuestion(question);
        option3.setQuestion(question);
   
        options.add(option1);
        options.add(option2);
        options.add(option3);
  
        question.setOption(options);
        questionService.saveQuestion(question);

        return new ModelAndView("redirect:/admin");
    }
    
   
}