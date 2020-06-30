package com.lxisoft.mockexam.web.rest;

import com.lxisoft.mockexam.domain.Exam;
import com.lxisoft.mockexam.service.ExamService;
import liquibase.pro.packaged.M;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClientForwardController {


    @Autowired
    ExamService examService;


    /**
     * Forwards any unmapped paths (except those containing a period) to the client {@code index.html}.
     * @return forward to client {@code index.html}.
     */
    @GetMapping(value = "/**/{path:[^\\.]*}")
    public String forward() {
        return "forward:/";
    }

    @GetMapping(value = "/admin")
    public ModelAndView adminPage()
    {
        List<Exam> mockexamData = examService.getExamData();
        ModelAndView model = new ModelAndView();
        model.addObject("data",mockexamData);
        model.setViewName("admin");
        return model;
    }

}
