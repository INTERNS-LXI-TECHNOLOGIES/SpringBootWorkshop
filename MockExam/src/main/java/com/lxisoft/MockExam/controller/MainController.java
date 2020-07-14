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
	
	@GetMapping("/admin")
	public ModelAndView home()
	{
        MockQuestion mockExam = new MockQuestion();
        ModelAndView model = new ModelAndView();
        List<Question> question= questionService.getAll();
        //System.out.println("size : " + question.size());
     //   model.addObject("mockExam",mockExam);
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

        return new ModelAndView("admin");
    }
    
    @RequestMapping(value = "/displayQues")
    public ModelAndView displayQuestions(@RequestParam("id") int questId)
    {
        Question quest = questionService.get(questId);
        MockQuestion mockQuestion = new MockQuestion();

        Question question = new Question();
        String ques = quest.getQuestion();
        question.setQuestion(ques);
        mockQuestion.setQuestion(question);

        Answer answer = new Answer();
        answer = question.getAnswer();
        mockQuestion.setAnswer(answer);

        List<Options> option = question.getOption();

        Options option1 = option.get(0);
        Options option2 = option.get(1);
        Options option3 = option.get(2);
   
        mockQuestion.setOption1(option1.getOption());
        mockQuestion.setOption2(option2.getOption());
        mockQuestion.setOption3(option3.getOption());
       
        ModelAndView model = new ModelAndView();
        model.addObject("mockQuestion",mockQuestion);
        model.setViewName("display");
        return model;
    }
    @RequestMapping(value = "/getAllQuestions")
    public ModelAndView showAllQuest()
    {
        List<Question> questionList = questionService.getAll();
        ModelAndView model = new ModelAndView();
        model.addObject("show",questionList);
        model.setViewName("questionList");
        return model;
    }
    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteQuestion(@PathVariable("id") int questId)
    {
        questionService.deleteById(questId);
        return new ModelAndView("redirect:/admin");
    }
    @GetMapping("/updateQuest")
    public ModelAndView get()
    {
        MockQuestion mockExam = new MockQuestion();
        ModelAndView model = new ModelAndView();
        model.addObject("mockExam",mockExam);
        model.setViewName("addQuestion");
        return model;
    }
    @RequestMapping(value = "/update/{id}")
    public ModelAndView questById(@PathVariable("id") int questId)
    {
        Question question = questionService.get(questId);
        MockQuestion mockQuestion = new MockQuestion();

        System.out.println(question.getId());
        mockQuestion.setId(question.getId());
        System.out.println(mockQuestion.getId());


        String quest = question.getQuestion();
        question.setQuestion(quest);
        mockQuestion.setQuestion(question);
        mockQuestion.setAnswer(question.getAnswer());

        List<Options> ops = question.getOption();
        Options option1 = ops.get(0);
        String opts1 = option1.getOption();
        mockQuestion.setOption1(opts1);

        Options option2 = ops.get(1);
        String opts2 = option2.getOption();
        mockQuestion.setOption2(opts2);

        Options option3 = ops.get(2);
        String opts3 = option3.getOption();
        mockQuestion.setOption3(opts3);

        ModelAndView model = new ModelAndView();
        model.addObject("questById",mockQuestion);
        model.setViewName("update");
        return model;
    }
}