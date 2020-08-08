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
	
	
	  	private QuestionService questionService;
	    private AnswerService answerService;
	    private OptionService optionService;
	    private UserService userService;
        private int i=0;
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
		model.addObject("listQuestions",question);
        model.setViewName("admin");
		return model;
	}
    
    /*@GetMapping("/user")
    public ModelAndView exam()
    {
        MockQuestion mockExam = new MockQuestion();
        ModelAndView model = new ModelAndView();
        List<Question> question= questionService.getAll();
        model.addObject("listExam",question);
        model.setViewName("view");
        return model;
    }*/
	

	@GetMapping("/logout")
    public String logout(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.invalidate();
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
        

        Question question = new Question();
        String ques = mockExam.getQuestion();
        question.setQuestion(ques);

       // Question question = mockExam.getQuestion();
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
    
    @RequestMapping(value = "/displayQues")
    public ModelAndView displayQuestions(@RequestParam("id") int questId)
    {
        Question quest = questionService.findById(questId);
        MockQuestion mockQuestion = new MockQuestion();

       /* Question question = new Question();
        String ques = quest.getQuestion();
        question.setQuestion(ques);*/
        mockQuestion.setQuestion(quest.getQuestion());

        Answer answer = new Answer();
        answer = quest.getAnswer();
        mockQuestion.setAnswer(answer);

        List<Options> option = quest.getOption();

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
    @GetMapping("/updateQuest/{id}")
    public ModelAndView updateQuest(@PathVariable("id") int questId)
    {
        Question question = questionService.findById(questId);
        MockQuestion mockExam = new MockQuestion();
        mockExam.setId(question.getId());
       /* Question quest = new Question();
        String ques = question.getQuestion();
        quest.setQuestion(ques);*/
        mockExam.setQuestion(question.getQuestion());
        mockExam.setAnswer(question.getAnswer());
        
        List<Options> option = question.getOption();
        Options option1 = option.get(0);
        Options option2 = option.get(1);
        Options option3 = option.get(2);
        
        mockExam.setOption1(option1.getOption());
        mockExam.setOption2(option2.getOption());
        mockExam.setOption3(option3.getOption());
       
        ModelAndView model = new ModelAndView();
        model.addObject("mockExam",mockExam);
        model.setViewName("update");
        return model;
    }
    @RequestMapping(value = "/update")
    public ModelAndView questionById(@ModelAttribute("mockExam") MockQuestion mockExam)
    {
        
        Question question = questionService.findById(mockExam.getId());
      /*  Question ques = new Question();
        Answer answer = mockExam.getAnswer();
        ques = mockExam.getQuestion();*/
        question.setQuestion(mockExam.getQuestion());
        Answer answer = mockExam.getAnswer();
        question.setAnswer(answer);
        List<Options> options = question.getOption() ;  
        options.get(0).setOption(mockExam.getOption1());
        options.get(1).setOption(mockExam.getOption2());
        options.get(2).setOption(mockExam.getOption3());
        
        question.setOption(options);
        questionService.saveQuestion(question);

        return new ModelAndView("redirect:/admin");
    }


     @GetMapping("/user")
    public ModelAndView viewQuestion(ModelAndView model) {
        List<Question> questions= questionService.getAll();
        //ModelAndView model = new ModelAndView();
        if(i<questions.size())
        {
         
        Question question = questions.get(i);
        MockQuestion mockExam = new MockQuestion();
        mockExam.setId(question.getId());
        /*Question quest = new Question();
        String ques = question.getQuestion();
        quest.setQuestion(ques);
        mockExam.setQuestion(quest);
*/
        mockExam.setQuestion(question.getQuestion());
        mockExam.setAnswer(question.getAnswer());
        
        List<Options> option = question.getOption();
        Options option1 = option.get(0);
        Options option2 = option.get(1);
        Options option3 = option.get(2);
        
        mockExam.setOption1(option1.getOption());
        mockExam.setOption2(option2.getOption());
        mockExam.setOption3(option3.getOption());
            
            model.addObject("mockExam",mockExam);
            model.setViewName("view");
            i++;

            if(quest.equals(question.getAnswer()));
                {
                    mark=mark+1;

                }

            return model;
        }

         else
        {
            model.setViewName("result");
            return model;
        }

        
    }
}




   /*     @GetMapping(value="/user")
    public ModelAndView viewQuestion(ModelAndView model,HttpServletRequest request) {
        List<Question> listQuestion = questionService.getAll();
        if(i<listQuestion.size())
        {
        Question question=listQuestion.get(i);
        Mock exam=new Mock();       
        exam.setQuestion(question.getQuestion());
        exam.setAnswer(question.getAnswer().getAnswer());
        exam.setOption1(question.getOptions().get(0).getQOption());
        exam.setOption2(question.getOptions().get(1).getQOption());
        exam.setOption3(question.getOptions().get(2).getQOption());
        exam.setOption4(question.getOptions().get(3).getQOption());        
//        List<Mock> listExam = new ArrayList<>();
//        listExam.add(exam);
        model.addObject("exam", exam);  
        model.setViewName("view");
        i++;
        return model;
        }
        else
        {
            model.setViewName("result");
        return model;
        }
    }*/




     /* @RequestMapping(value = "/selectOption", method = RequestMethod.GET)
      public ModelAndView seletedOption(HttpServletRequest request,HttpServletResponse res)
      {

        ModelAndView model=null;
          HttpSession sessions = request.getSession(true);
          //int selected =  Integer.parseInt(request.getParameter("option"));
          String quest=request.getParameter("option");
          int count = Integer.parseInt(request.getParameter("count"));
          @SuppressWarnings("unchecked")
          int mark=0;
          List<MockModel> listQuestions = (List<MockModel>)sessions.getAttribute("listQuestions");

            if(count<listQuestions.size())  
            {

                if(quest.equals(listQuestions.get(count-1).getAnswer()));
                {
                    mark=mark+1;

                }

                model = new ModelAndView("view");
            }
            else
            {
                model = new ModelAndView("view");
            }
            model.addObject("listQuestions", listQuestions);
            sessions.setAttribute("Mark", mark);
            return model;
      }*/

