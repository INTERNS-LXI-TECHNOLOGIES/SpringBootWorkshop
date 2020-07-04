package com.lxisoft.TestMockExam.controller;

import com.lxisoft.TestMockExam.domain.Answer;
import com.lxisoft.TestMockExam.domain.Question;
import com.lxisoft.TestMockExam.domain.QuestionOption;
import com.lxisoft.TestMockExam.model.ExamModel;
import com.lxisoft.TestMockExam.repository.AnswerRepository;
import com.lxisoft.TestMockExam.repository.QuestionOptionRepository;
import com.lxisoft.TestMockExam.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
public class TestMockController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping(value = "/")
    public String homePage(){
        return "Home";
    }

    @GetMapping(value = "/admin")
    public String adminPage(){
            return "Admin";
    }

    @GetMapping(value = "/addQuestion")
    public ModelAndView createModelForAddNewQuestion(ModelAndView modelAndView){
        ExamModel examModel = new  ExamModel();
        modelAndView.addObject("examModel",examModel);
        modelAndView.setViewName("Add");
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public String addNewQuestion(@ModelAttribute ExamModel examModel){
        Set<QuestionOption> questionOptions = new HashSet<>();
        QuestionOption option1 = new QuestionOption();
        option1.setQnOption(examModel.getOption1());
        questionOptions.add(option1);

        QuestionOption option2 = new QuestionOption();
        option2.setQnOption(examModel.getOption2());
        questionOptions.add(option2);

        QuestionOption option3 = new QuestionOption();
        option3.setQnOption(examModel.getOption3());
        questionOptions.add(option3);

        QuestionOption option4 = new QuestionOption();
        option4.setQnOption(examModel.getOption4());
        questionOptions.add(option4);

        Answer answer = new Answer();
        answer.setAnswer(examModel.getAnswer());
            Question question = new Question(examModel.getQuestion(),answer,questionOptions);
           questionRepository.save(question);
            //answerRepository.save(examModel.getAnswer());
        return "Admin";
    }
}
