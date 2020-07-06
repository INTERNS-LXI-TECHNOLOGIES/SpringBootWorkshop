package com.lxisoft.mockexam.controller;

import com.lxisoft.mockexam.entity.Answer;
import com.lxisoft.mockexam.entity.MCQ;
import com.lxisoft.mockexam.entity.Options;
import com.lxisoft.mockexam.entity.Question;
import com.lxisoft.mockexam.service.AnswerService;
import com.lxisoft.mockexam.service.OptionService;
import com.lxisoft.mockexam.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExamController {

    private QuestionService questionService;
    private AnswerService answerService;
    private OptionService optionService;
    public ExamController(QuestionService questionService, AnswerService answerService, OptionService optionService)
    {
        this.questionService = questionService;
        this.answerService = answerService;
        this.optionService = optionService;
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
        Question question = mcq.getQuest();
        Answer answer = mcq.getAns();

        question.setAnswer(answer);

        List<Options> op = new ArrayList<Options>();

        Options opt1 = new Options();

        Options opt2 = new Options();

        Options opt3 = new Options();

        Options opt4 = new Options();

        opt1.setOpt(mcq.getOpt1());
        opt2.setOpt(mcq.getOpt2());
        opt3.setOpt(mcq.getOpt3());
        opt4.setOpt(mcq.getOpt4());

        opt1.setQuestion(question);
        opt2.setQuestion(question);
        opt3.setQuestion(question);
        opt4.setQuestion(question);

        op.add(opt1);
        op.add(opt2);
        op.add(opt3);
        op.add(opt4);


        questionService.saveQuestion(question);
        answerService.saveAnswer(answer);
        optionService.saveOptions(op);

        return new ModelAndView("admin");
    }
}
