package com.lxisoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.model.*;
import com.lxisoft.service.*;

@Controller
public class MockController {
	
	 @Autowired
	 private MockService mockService;
	
	 @RequestMapping(value = "/addQuestions", method = RequestMethod.GET)
     public ModelAndView newContact(ModelAndView model) {
        MockModel mockModel = new MockModel();
        model.addObject("mockModel", mockModel);
        model.setViewName("Add");
        return model;
    }
	
	  @RequestMapping(value = "/add", method = RequestMethod.POST)
	 public String addQuestion(@ModelAttribute MockModel mockModel) {
		System.out.println(mockModel.getId());
	        if (mockModel.getId() == 0) {
	            mockService.addMockQuestion(mockModel);
	            return "DoneAdd";
	        } else {
	            mockService.editQuestion(mockModel);
	            return "editSuccess";
	        }    
	        
	    }

	 @RequestMapping(value = "/displayAll")
     public ModelAndView getAllQuestions(ModelAndView model) throws IOException {
        List<MockModel> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("View");
        return model;
    }

     @RequestMapping(value = "/delete")
     public ModelAndView removeQuestion(ModelAndView model) throws IOException {
        List<MockModel> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("Delete");
        return model;
    }

	 @RequestMapping(value = "/deleteQuest", method = RequestMethod.GET)
	    public String deleteQuest(HttpServletRequest request) {
	        int questionId = Integer.parseInt(request.getParameter("id"));
	        mockService.deleteQuest(questionId);
	        return "deleteDone";
	 }


	 @RequestMapping(value = "/editQuest")
     public ModelAndView questionUpdate(ModelAndView model) throws IOException {
        List<MockModel> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("Edit");
        return model;
    }
	
	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
	  public ModelAndView editQuestions(HttpServletRequest request){
	    int questionId = Integer.parseInt(request.getParameter("id"));
	        MockModel mockModel = mockService.getQuestionId(questionId);
	        ModelAndView model = new ModelAndView("editQuestion");
	        model.addObject("mockModel1", mockModel);
	        return model;
	 }

	 @RequestMapping(value = "/userView")
	     public String userQuestionDisplay(HttpServletRequest request) throws IOException {
	        List<MockModel> listQuestions = mockService.getAllQuestions();
	        HttpSession sessions = request.getSession(true);
	        sessions.setAttribute("listQuestions", listQuestions);
	       return "Exam";
		 }

		  @RequestMapping(value = "/selectOption", method = RequestMethod.GET)
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

				model = new ModelAndView("Exam");
			}
			else
			{
				model = new ModelAndView("Exam");
			}

		  	sessions.setAttribute("listQuestions", listQuestions);
		  	sessions.setAttribute("Mark", mark);
		  	return model;
	  }
	 
	   @RequestMapping(value = "/result", method = RequestMethod.GET)
	public String resultCalculation(HttpServletRequest request)
	  {
		HttpSession sessions = request.getSession(true);
		int mark = Integer.parseInt(sessions.getAttribute("Mrk").toString());
		sessions.setAttribute("Mark", mark);
		@SuppressWarnings("unchecked")
		List<MockModel> listQuestions = (List<MockModel>)sessions.getAttribute("listQuestions");

		return "Result";
	  }
	  
}