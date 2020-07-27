package com.lxisoft.MockexamSecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

        return "Admin";
    }
}

