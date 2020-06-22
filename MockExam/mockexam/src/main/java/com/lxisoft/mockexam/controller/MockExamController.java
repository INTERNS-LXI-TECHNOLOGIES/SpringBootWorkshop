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
import java.util.ArrayList;
import java.util.List;

@Controller
public class MockExamController
{
    @Autowired
    ExamService examService;

    private static int count=0;
    private ArrayList<String> answerList = new ArrayList<String>();
    private String answers;
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

    @RequestMapping(value = "/getExamData")
    public String getExamData(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        List<Exam> data = examService.getExamData();
        session.setAttribute("data",data);
        return "instruction";
    }

    @RequestMapping(value = "/processExam")
    public ModelAndView loopQuestions(HttpServletRequest request) {
        answerList.clear();
        HttpSession session = request.getSession();
        List<Exam> questionBank = (List<Exam>) session.getAttribute("data");
        Exam exam = questionBank.get(count);
        ModelAndView model = new ModelAndView();
        model.addObject("quest",exam);
        model.setViewName("questions");
        return model;

    }

    @RequestMapping(value = "/process")
    public ModelAndView Questions(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Exam> questionBank = (List<Exam>) session.getAttribute("data");
        String answer = request.getParameter("ans");
        answerList.add(answer);
        count++;
        session.setAttribute("answers",answerList);
        if(count < questionBank.size())
        {
            Exam exam = questionBank.get(count);
            ModelAndView model = new ModelAndView();
            model.addObject("quest",exam);
            model.setViewName("questions");
            return model;
        }
        else
        {
            return  new ModelAndView("redirect:/result");
        }

    }

    @RequestMapping(value = "/result")
    public ModelAndView viewResult(HttpServletRequest request)
    {
        int mark=0;
        HttpSession session = request.getSession();
        List<Exam> questionBank = (List<Exam>) session.getAttribute("data");
        ArrayList<String> ansList = (ArrayList<String>) session.getAttribute("answers");

        for (int x=0;x<questionBank.size();x++)
        {
            for (int y=0;y<ansList.size();y++)
            {
                if(questionBank.get(x).getAnswer().equals(ansList.get(y)))
                {
                    mark ++;
                }
            }
        }
        count=0;
        System.out.println(mark);
        ModelAndView model = new ModelAndView();
        model.addObject("listOne",questionBank);
        model.addObject("listTwo",ansList);
        model.addObject("result",mark);
        model.setViewName("result");
        return model;
    }

    @RequestMapping(value = "/login")
    public String loginPage()
    {
        return "login";
    }

    @RequestMapping(value = "/register")
    public String registerPage()
    {
        return "register";
    }

}
