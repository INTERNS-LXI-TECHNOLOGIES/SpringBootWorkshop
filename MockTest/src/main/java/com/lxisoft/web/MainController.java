package com.lxisoft.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lxisoft.service.*;
import com.lxisoft.entity.*;
import com.lxisoft.model.Exam;
import com.lxisoft.model.Mock;
import com.lxisoft.repository.QuestionRepository;

@Controller
public class MainController {
	private int i=0;
	
	@Autowired
	private QuestionService questionService;
	
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
    
    @RequestMapping(value = "/newquestion", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Exam exam = new Exam();
        model.addObject("exam", exam);
        model.setViewName("add");
        return model;
    }
    
    @GetMapping(value = "/add")
    public ModelAndView addNewQuestion(@ModelAttribute Exam exam,ModelAndView model){
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
        questionService.saveQuestion(question);
        
        List<Question> listExam = questionService.getAll();
    	model.addObject("listExam", listExam);
        model.setViewName("read");
        return model;
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
        exam.setOption1(question.getOptions().get(0).getQOption());
        exam.setOption2(question.getOptions().get(1).getQOption());
        exam.setOption3(question.getOptions().get(2).getQOption());
        exam.setOption4(question.getOptions().get(3).getQOption());

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
        question.getOptions().get(0).setQOption(exam.getOption1());
        question.getOptions().get(1).setQOption(exam.getOption2());
        question.getOptions().get(2).setQOption(exam.getOption3());
        question.getOptions().get(3).setQOption(exam.getOption4());
        questionService.saveQuestion(question);
        return "/SuccUpdate";
    } 
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView ditContact(@PathVariable("id") int id,ModelAndView model) {
        Exam exam = new Exam();
        questionService.deleteById(id);
        model.addObject("exam", exam);
        model.setViewName("delete");
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
    
    @GetMapping(value="viewQuestion")
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
    }
    
    @GetMapping("/view")
    public String viewQuestion(HttpServletRequest request) {
    	HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<Mock> listExam = (List<Mock>)session.getAttribute("listExam");
		int selectedOption = 0;
		  if(request.getParameter("option")!= null)
		  {
			   selectedOption =  Integer.parseInt(request.getParameter("option"));
		  }
		  
		  switch(selectedOption)
		  {
		  case 1 :
			  listExam.get(i-1).setSelectedOption(listExam.get(i-1).getOption1());
			  break;
		  case 2 :
			  listExam.get(i-1).setSelectedOption(listExam.get(i-1).getOption2());
			  break;
		  case 3 :
			  listExam.get(i-1).setSelectedOption(listExam.get(i-1).getOption3());
			  break;
		  case 4 :
			  listExam.get(i-1).setSelectedOption(listExam.get(i-1).getOption4());
			  break;
		  default :
			  listExam.get(i-1).setSelectedOption("");
			  break;
		  }	
		  session.setAttribute("listExam", listExam);
		  return "view";
    }
    
    
    
    
    @GetMapping("/result")
    public ModelAndView examResult(ModelAndView model) {
    	int mark=0;
    	List<Question> ql =questionService.getAll();
    	
    	for(int i=0;i<ql.size();i++)
    	{
    		Question question=ql.get(i);
	    	Mock exam=new Mock();       
	    	exam.setQuestion(question.getQuestion());
	    	exam.setAnswer(question.getAnswer().getAnswer());
	    	exam.setOption1(question.getOptions().get(0).getQOption());
	        exam.setOption2(question.getOptions().get(1).getQOption());
	        exam.setOption3(question.getOptions().get(2).getQOption());
	        exam.setOption4(question.getOptions().get(3).getQOption());
	        exam.getSelectedOption();
	        List<Mock> listExam = new ArrayList<>();
	        listExam.add(exam);
//	        model.addObject("listExam", listExam);
    		
    		if(listExam.get(i).getAnswer().equals(listExam.get(i).getSelectedOption()))
    		{
    			mark++;
    		}
    				
    	}
    	model.addObject("mark", mark);
    	model.setViewName("result");
		return model;
    }
    
   
}
