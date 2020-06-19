package com.lxisoft.controller;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lxisoft.entity.Exam;

@Controller
public class ExamController {
	private static final Logger logger = Logger
            .getLogger(ExamController.class);
 
    public ExamController() {
        System.out.println("ExamController()");
    }
    @RequestMapping(value="/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "index";
    }
 
    
    
    
}
