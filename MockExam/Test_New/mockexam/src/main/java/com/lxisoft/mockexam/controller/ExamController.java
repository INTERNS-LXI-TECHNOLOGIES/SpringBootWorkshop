package com.lxisoft.mockexam.controller;

import com.lxisoft.mockexam.entity.Answer;
import com.lxisoft.mockexam.entity.MCQ;
import com.lxisoft.mockexam.entity.Question;
import com.lxisoft.mockexam.service.AnswerService;
import com.lxisoft.mockexam.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExamController {

    private QuestionService questionService;
    private AnswerService answerService;
    public ExamController(QuestionService questionService, AnswerService answerService)
    {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping("/start")
    public ModelAndView get()
    {
        MCQ mcq = new MCQ();
        ModelAndView model = new ModelAndView();
        model.addObject("mcq",mcq);
        model.setViewName("add");
        return model;
    }

    @PostMapping(value = "/add")
    public ModelAndView data(@ModelAttribute("mcq") MCQ mcq)
    {
        questionService.saveQuestion(mcq.getQuest());
        answerService.saveAnswer(mcq.getAns());

        return new ModelAndView("admin");
    }
}
