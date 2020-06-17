package com.lxisoft.mockexam.controller;

import com.lxisoft.mockexam.entity.Exam;
import com.lxisoft.mockexam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
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
    @RequestMapping(value = "/update/{id}")
    public ModelAndView updateQuestion(@PathVariable("id") int qId)
    {
        ModelAndView model = new ModelAndView();
        Exam question = examService.getQuestionById(qId);
        model.addObject("questionById",question);
        model.setViewName("update");
        return model;
    }

    @RequestMapping(value = "/updateQuestion")
    public ModelAndView update(@ModelAttribute Exam exam)
    {
        examService.saveQuestion(exam);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteQuestion(@PathVariable("id") int qId)
    {
        examService.deleteQuestion(qId);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }

    @RequestMapping(value = "/introduction")
    public String instruction()
    {
        return "instruction";
    }
}
