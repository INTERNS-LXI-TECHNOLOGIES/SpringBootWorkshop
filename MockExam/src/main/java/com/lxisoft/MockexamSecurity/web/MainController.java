package com.lxisoft.MockexamSecurity.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.MockexamSecurity.entity.AnsOption;
import com.lxisoft.MockexamSecurity.entity.Answer;
import com.lxisoft.MockexamSecurity.entity.Question;
import com.lxisoft.MockexamSecurity.model.ExamModel;
import com.lxisoft.MockexamSecurity.repository.AnsOptionRepository;
import com.lxisoft.MockexamSecurity.repository.AnswerRepository;
import com.lxisoft.MockexamSecurity.repository.QuestionRepository;



@Controller
public class MainController {
	
	 @Autowired
	    private QuestionRepository questionRepository;
	 @Autowired
	    private AnswerRepository answerRepository;
	 @Autowired
	    private AnsOptionRepository questionOptionRepository;

	    

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
    
    @GetMapping("/home")
    public String homeIndex() {
        return "home";
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
    	List<AnsOption> ansOptions = new ArrayList<>();
        Question question = examModel.getQuestion();
        Answer answer = examModel.getAnswer();
        answer.setQuestion(question);
        question.setAnswer(answer);
        
        AnsOption option1 = new AnsOption();
        AnsOption option2 = new AnsOption();
        AnsOption option3 = new AnsOption();
        AnsOption option4 = new AnsOption();
        
       
        option1.setAnsOption(examModel.getOption1());
        option2.setAnsOption(examModel.getOption2());
        option3.setAnsOption(examModel.getOption3());
        option4.setAnsOption(examModel.getOption4());

        option1.setQuestion(question);
        option2.setQuestion(question);
        option3.setQuestion(question);
        option4.setQuestion(question);

        ansOptions.add(option1);
        ansOptions.add(option2);
        ansOptions.add(option3);
        ansOptions.add(option4);

        question.setOptions(ansOptions);        
        questionService.saveQuestion(question);
       return "Admin";
    }
    /* @GetMapping(value = "/viewAll")
    public ModelAndView listExam(ModelAndView model) throws IOException {
        List<Question> listExam = questionService.getAll();
        model.addObject("listExam", listExam);
        model.setViewName("read");
        return model;
    }
    
    @GetMapping(value = "/update/{id}")
    public ModelAndView updateQuestion(@PathVariable("id") long id)
    {
    	ModelAndView modelAndView = new ModelAndView();
        Question question = questionService.get(id);
        Exam exam = new Exam();
        exam.setId(question.getId());
        String quest = question.getQuestion();
        question.setQuestion(quest);
        exam.setQuestion(question);
        exam.setAnswer(question.getAnswer());
        exam.setOption1(question.getOptions().get(0).getQOption());
        exam.setOption2(question.getOptions().get(1).getQOption());
        exam.setOption3(question.getOptions().get(2).getQOption());
        exam.setOption4(question.getOptions().get(3).getQOption());

        modelAndView.addObject("updateQ",exam);
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @GetMapping(value = "/updateQ")
    public String updateQuestion(@ModelAttribute Exam exam)
    {
        Question question = questionService.get(exam.getId());
        Question q = exam.getQuestion();
        question.setQuestion(q.getQuestion());
        question.getAnswer().setAnswer(exam.getAnswer().getAnswer());
        question.getOptions().get(0).setQOption(exam.getOption1());
        question.getOptions().get(1).setQOption(exam.getOption2());
        question.getOptions().get(2).setQOption(exam.getOption3());
        question.getOptions().get(3).setQOption(exam.getOption4());
        questionService.saveQuestion(question);
        return "index";
    } 
    
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteQuest(@PathVariable("id") int id,ModelAndView model) {
    	long examId = (long)id;
    	questionService.deleteById(examId);
    	List<Question> listExam = questionService.getAll();
    	model.addObject("listExam", listExam);
        model.setViewName("read");
        return model;  
  }
    */

}


