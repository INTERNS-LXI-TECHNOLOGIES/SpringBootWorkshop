package com.lxisoft.MockExam.controller;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.jboss.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lxisoft.MockExam.entity.MockEntity;

@Controller
public class MockController 
{


	private static final Logger logger = Logger.getLogger(MockController.class);
	public MockController() 
	{
        System.out.println("MockController()");
    }
	

	@RequestMapping(value= "/")
	public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "index";
		
	}

	@RequestMapping(value = "/home")
    public ModelAndView getAdmin(ModelAndView model)
	{
		List<MockEntity> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("Admin");
        return model;
    }
}