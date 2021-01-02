package com.lxisoft.controller;

import com.lxisoft.exception.ResourceNotFoundException;
import com.lxisoft.model.Exam;
import com.lxisoft.service.examService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.service.examService;
import org.thymeleaf.model.IModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class examController {
    private static final Logger LOG = LoggerFactory.getLogger(examController.class);
    int count=0;

    @Autowired
    private examService examservice;

    @GetMapping(value = {"/", "/home"})
    public ModelAndView index()
    {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model theModel) {

        LOG.debug("inside show exam-form handler method");
        Exam theExam = new Exam();
        theModel.addAttribute("exam", theExam);
        return "add";
    }
    @RequestMapping(value = "/saveExam",method = RequestMethod.POST)
    public String saveExam(@ModelAttribute("exam") Exam theExam) {
        examservice.save(theExam);
        return "redirect:list";

    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listCustomers(Model theModel) {
        List < Exam > theExam = examservice.getExam();
        theModel.addAttribute("exam", theExam);
        return "list";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showFormForUpdate(@PathVariable("id") int theId,
                                    Model theModel) throws ResourceNotFoundException {
        Exam theExam = examservice.getExam(theId);
        theModel.addAttribute("exam", theExam);
        return "update";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteExam(@PathVariable("id") int theId) throws ResourceNotFoundException {
        examservice.deleteExam(theId);
        return "redirect:/list";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String seletedOption(HttpServletRequest request, HttpServletResponse response, Model models) throws IOException
    {
        HttpSession sessions = request.getSession(true);
        int selectedOption =  Integer.parseInt(request.getParameter("opt"));
        @SuppressWarnings("unchecked")
        List<Exam> listQuestions = (List<Exam>)sessions.getAttribute("exam");

        if(selectedOption == 1)
        {
            listQuestions.get(count).setSelectedOption(1);
        }
        else if(selectedOption == 2)
        {
            listQuestions.get(count).setSelectedOption(2);
        }
        else if(selectedOption == 3)
        {
            listQuestions.get(count).setSelectedOption(3);
        }
        else if(selectedOption == 4)
        {
            listQuestions.get(count).setSelectedOption(4);
        }
        sessions.setAttribute("listQuestions", listQuestions);
        count++;
        return "redirect:/exam";

    }

}
