package com.lxisoft.MockexamSecurity.web;

import java.io.IOException;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.MockexamSecurity.entity.AnsOption;
import com.lxisoft.MockexamSecurity.entity.Answer;
import com.lxisoft.MockexamSecurity.entity.Question;
import com.lxisoft.MockexamSecurity.model.Exam;
import com.lxisoft.MockexamSecurity.model.MockExam;
import com.lxisoft.MockexamSecurity.repository.QuestionRepository;
import com.lxisoft.MockexamSecurity.service.AnswerService;
import com.lxisoft.MockexamSecurity.service.OptionService;
import com.lxisoft.MockexamSecurity.service.QuestionService;



@Controller
public class MainController {
	
	@Autowired
    private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionService questionService;
	@Autowired
    private AnswerService answerService;
	@Autowired
    private OptionService optionService;
	  
	private static int count=0;
    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminView(ModelAndView model) {
             
        model.setViewName("admin");
        return model;
    }   
   
    
    @RequestMapping(value = "/newquestion", method = RequestMethod.GET)
    public ModelAndView newQuestion(ModelAndView model) {
        Exam exam = new Exam();
        model.addObject("exam", exam);
        model.setViewName("add");
        return model;
    }
    @GetMapping(value = "/add")
    public String addNewQuestion(@ModelAttribute Exam exam){
    	List<AnsOption> ansOptions = new ArrayList<>();
        Question question = exam.getQuestion();
        Answer answer = exam.getAnswer();
        answer.setQuestion(question);
        question.setAnswer(answer);
        
        AnsOption option1 = new AnsOption();
        AnsOption option2 = new AnsOption();
        AnsOption option3 = new AnsOption();
        AnsOption option4 = new AnsOption();
             
        option1.setAOption(exam.getOption1());
        option2.setAOption(exam.getOption2());
        option3.setAOption(exam.getOption3());
        option4.setAOption(exam.getOption4());

        option1.setQuestion(question);
        option2.setQuestion(question);
        option3.setQuestion(question);
        option4.setQuestion(question);

        ansOptions.add(option1);
        ansOptions.add(option2);
        ansOptions.add(option3);
        ansOptions.add(option4);

        question.setOptions(ansOptions);        
        questionService.saveQuestion(question);
       return "admin";
    }
    @GetMapping(value = "/viewAll")
    public ModelAndView listExam(ModelAndView model) throws IOException {
        List<Question> listExam = questionService.getAll();
        model.addObject("listExam", listExam);
        model.setViewName("read");
        return model;
    }
    @GetMapping(value = "/update/{id}")
    public ModelAndView updateQuestion(@PathVariable("id") long id)
    {
    	ModelAndView modelAndView = new ModelAndView();
        Question question = questionService.get(id);
        Exam exam = new Exam();
        exam.setId(question.getId());
        String quest = question.getQuestion();
        question.setQuestion(quest);
        exam.setQuestion(question);
        exam.setAnswer(question.getAnswer());
        exam.setOption1(question.getOptions().get(0).getAOption());
        exam.setOption2(question.getOptions().get(1).getAOption());
        exam.setOption3(question.getOptions().get(2).getAOption());
        exam.setOption4(question.getOptions().get(3).getAOption());

        modelAndView.addObject("updateQ",exam);
        modelAndView.setViewName("update");
        return modelAndView;
    }
    
    @GetMapping(value = "/updateQ")
    public String updateQuestion(@ModelAttribute Exam exam)
    {
        Question question = questionService.get(exam.getId());
        Question q = exam.getQuestion();
        question.setQuestion(q.getQuestion());
        question.getAnswer().setAnswer(exam.getAnswer().getAnswer());
        question.getOptions().get(0).setAOption(exam.getOption1());
        question.getOptions().get(1).setAOption(exam.getOption2());
        question.getOptions().get(2).setAOption(exam.getOption3());
        question.getOptions().get(3).setAOption(exam.getOption4());
        questionService.saveQuestion(question);
        return "success";
    }     

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletetQuestion(@PathVariable("id") int id,ModelAndView model) {
        Exam exam = new Exam();
        questionService.deleteById(id);
        model.addObject("exam", exam);
        model.setViewName("deleteConfirmation");
        return model;
    }    
    
    @GetMapping(value = "/delete")
    public ModelAndView deleteQuest(@PathVariable("id") int id,ModelAndView model) {
    	long examId = (long)id;
    	questionService.deleteById(examId);
    	List<Question> listExam = questionService.getAll();
    	model.addObject("listExam", listExam);
        model.setViewName("read");
        return model;  
  }    
          
 /*   @GetMapping(value = "/authentication")
    public String userAuthentication()
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	boolean hasRole = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
    	if(hasRole)
    	{
    		return "redirect:/admin";
    	}
    	else
    	{
    		return "redirect:/user";
    	}
    }
  */
      
    
    @GetMapping("/userPage")
	public String setQuestionsSession(HttpServletRequest request) {
		HttpSession sessions = request.getSession(true);
		List<Question> listQuestions = questionService.getAll();
		sessions.setAttribute("listQuestions", listQuestions);
		return "instructions";
	}
 
    @GetMapping(value="startExam")
    public String viewQuestion(HttpServletRequest request) {
    	List<Question> listQuestion = questionService.getAll();
    	List<MockExam> listExam = new ArrayList<>();
    	HttpSession session = request.getSession(true);
    	for(int i=0;i<listQuestion.size();i++)
    	{
	    	Question question=listQuestion.get(i);
	    	MockExam exam=new MockExam();       
	    	exam.setQuestion(question.getQuestion());
	    	exam.setAnswer(question.getAnswer().getAnswer());
	    	exam.setOption1(question.getOptions().get(0).getAOption());
	        exam.setOption2(question.getOptions().get(1).getAOption());
	        exam.setOption3(question.getOptions().get(2).getAOption());
	        exam.setOption4(question.getOptions().get(3).getAOption());             
	        listExam.add(exam);
	        
    	}
    	session.setAttribute("listExam", listExam); 
    	return "redirect:/view";
    }
    
    @GetMapping("/view")
    public ModelAndView viewQuestion(ModelAndView model,HttpServletRequest request) {
    	HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<MockExam> listExam = (List<MockExam>)session.getAttribute("listExam");
		if(count<listExam.size())
    	{
		 model.addObject("listExam", listExam.get(count));
		 count++;
		 model.setViewName("view"); 
        return model;
		}
		else
		{
			count=0;
			model.setViewName("redirect:/result");
			return model;
		}
    }
    
    @GetMapping("/selectedOption")
	public String selectedOption(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<MockExam> listExam = (List<MockExam>)session.getAttribute("listExam");
		int selectedOption = 0;
		  if(request.getParameter("option")!= null)
		  {
			   selectedOption =  Integer.parseInt(request.getParameter("option"));
		  }
		  
		  switch(selectedOption)
		  {
		  case 1 :
			  listExam.get(count-1).setSelectedOption(listExam.get(count-1).getOption1());
			  break;
		  case 2 :
			  listExam.get(count-1).setSelectedOption(listExam.get(count-1).getOption2());
			  break;
		  case 3 :
			  listExam.get(count-1).setSelectedOption(listExam.get(count-1).getOption3());
			  break;
		  case 4 :
			  listExam.get(count-1).setSelectedOption(listExam.get(count-1).getOption4());
			  break;
		  default :
			  listExam.get(count-1).setSelectedOption("");
			  break;
		  }
		  
		  session.setAttribute("listExam", listExam);
			
		return "redirect:/view";
	}
    
    
    
    @GetMapping("/result")
    public ModelAndView examResult(ModelAndView model,HttpSession session) {
    	@SuppressWarnings("unchecked")
		List<MockExam> listExam = (List<MockExam>)session.getAttribute("listExam");
		int mark = 0;
		for(int i =0;i<listExam.size();i++)
		  {
			if(listExam.get(i).getAnswer().equals(listExam.get(i).getSelectedOption()))
			{
				mark++;
			}
		  }
		model.addObject("mark", mark);
		model.addObject("listExam",listExam);
		model.setViewName("result");
		return model;
        }

    
    
    
    

		
}
    
       
    
    
    
    

