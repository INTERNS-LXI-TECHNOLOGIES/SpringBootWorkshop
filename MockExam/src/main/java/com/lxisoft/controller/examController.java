package com.lxisoft.controller;

import com.lxisoft.model.Exam;
import com.lxisoft.service.examService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.service.examService;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
public class examController {
    @Autowired
    examService examservice;

    @GetMapping(value = {"/", "/home"})
    public ModelAndView index()
    {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model theModel) {
        Exam theExam = new Exam();
        theModel.addAttribute("exam", theExam);
        return "exam-form";
    }
    @RequestMapping(value = "/saveExam",method = RequestMethod.GET)
    public String  saveExam(@ModelAttribute("exam") Exam theExam)
    {
        examservice.save(theExam);
        return "redirect:/list";

    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listCustomers(Model theModel) {
        List< Exam > theExam = examservice.getExam();
        theModel.addAttribute("exam", theExam);
        return "list-exam";
    }

}
