package com.lxisoft.mockexam.controller;

import com.lxisoft.mockexam.entity.Exam;
import com.lxisoft.mockexam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MockExamController
{
    @Autowired
    ExamService examService;

    @RequestMapping(value="/admin")
    public ModelAndView admin(ModelAndView model)
    {
        List<Exam> examData = examService.getExamData();
        model.addObject("data",examData);
        model.setViewName("admin");
        return model;
    }

    @RequestMapping(value = "/add")
    public ModelAndView addQuestionPage(ModelAndView model)
    {
        Exam exam = new Exam();
        model.addObject("exam",exam);
        model.setViewName("add");
        return model;
    }

    @RequestMapping(value = "/addQuestion")
    public ModelAndView addQuestion(@ModelAttribute Exam exam)
    {
        examService.saveQuestion(exam);
        return new ModelAndView("redirect:/admin");
    }
}
