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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class TestMockController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionOptionRepository questionOptionRepository;

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
        List<QuestionOption> questionOptions = new ArrayList<>();
        Question question = examModel.getQuestion();
        Answer answer = examModel.getAnswer();
        answer.setQuestion(question);

        question.setAnswer(answer);

        QuestionOption option1 = new QuestionOption();
        QuestionOption option2 = new QuestionOption();
        QuestionOption option3 = new QuestionOption();
        QuestionOption option4 = new QuestionOption();

        option1.setQnOption(examModel.getOption1());
        option2.setQnOption(examModel.getOption2());
        option3.setQnOption(examModel.getOption3());
        option4.setQnOption(examModel.getOption4());

        option1.setQuestion(examModel.getQuestion());
        option2.setQuestion(examModel.getQuestion());
        option3.setQuestion(examModel.getQuestion());
        option4.setQuestion(examModel.getQuestion());

        questionOptions.add(option1);
        questionOptions.add(option2);
        questionOptions.add(option3);
        questionOptions.add(option4);

        question.setQnOption(questionOptions);

        questionRepository.save(question);
       // answerRepository.save(answer);
        //questionOptionRepository.saveAll(questionOptions);
        return "Admin";
    }
}
