package com.lxisoft.mockexam.controller;

import com.lxisoft.mockexam.entity.*;
import com.lxisoft.mockexam.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.*;

@Controller
public class ExamController {

    private QuestionService questionService;
    private AnswerService answerService;
    private OptionService optionService;
    private UserService userService;
    private RoleService roleService;
    public ExamController(QuestionService questionService, AnswerService answerService, OptionService optionService,UserService userService,RoleService roleService)
    {
        this.questionService = questionService;
        this.answerService = answerService;
        this.optionService = optionService;
        this.userService = userService;
        this.roleService = roleService;
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
        /* Getting Question And Answer from Model*/
        Question question = mcq.getQuest();
        Answer answer = mcq.getAns();

        /* Setting Answer in Question Entity*/
        question.setAnswer(answer);


        List<Options> op = new ArrayList<Options>();

        /*Four options*/
        Options opt1 = new Options();
        Options opt2 = new Options();
        Options opt3 = new Options();
        Options opt4 = new Options();

        /* Setting Option In Each Object*/
        opt1.setOpt(mcq.getOpt1());
        opt2.setOpt(mcq.getOpt2());
        opt3.setOpt(mcq.getOpt3());
        opt4.setOpt(mcq.getOpt4());

        /*Setting Question in Option Entity*/
        opt1.setQuestion(question);
        opt2.setQuestion(question);
        opt3.setQuestion(question);
        opt4.setQuestion(question);

        /*Adding Each Option to List*/
        op.add(opt1);
        op.add(opt2);
        op.add(opt3);
        op.add(opt4);

        /* Setting Options in Question*/
        question.setOpts(op);

        /* Saving Questions */
        questionService.saveQuestion(question);


        return new ModelAndView("admin");
    }

    @RequestMapping(value = "/addUser")
    public ModelAndView addUser()
    {
        User user = new User();
        ModelAndView model = new ModelAndView();
        model.addObject("user",user);
        model.setViewName("register");
        return model;
    }

    @PostMapping(value = "/register")
    public ModelAndView register(@ModelAttribute("user") User reg)
    {
       Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");
       Set<Role> roles = new HashSet<Role>();
       roles.add(role1);
        roles.add(role2);
       reg.setRoles(roles);

       roleService.saveRole(role1);
        roleService.saveRole(role2);
       userService.saveUser(reg);
       return new ModelAndView("admin");
    }

    @RequestMapping(value = "/show")
    public String  show()
    {

        return "searchUser";
    }

    @RequestMapping(value = "/search")
    public ModelAndView showDetails(@RequestParam("id") int userId)
    {
        System.out.println(userId);
        User user = userService.findUserById(userId);
        System.out.println(user);
        return new ModelAndView("admin");
    }

    @RequestMapping(value = "/showQ")
    public String  showQ()
    {

        return "searchQuestion";
    }

    @RequestMapping(value = "/searchQ")
    public ModelAndView showQuestion(@RequestParam("id") int qId)
    {
        Question question = questionService.get(qId);

        System.out.println(question);

        MCQ mcq = new MCQ();

        Question q1 = new Question();
        String q = question.getQuestion();
        q1.setQuestion(q);
        mcq.setQuest(q1);

        Answer a1 = new Answer();
        a1 = question.getAnswer();
        mcq.setAns(a1);

        List<Options> op = question.getOpts();

        Options op1 = op.get(0);
        Options op2 = op.get(1);
        Options op3 = op.get(2);
        Options op4 = op.get(3);

        mcq.setOpt1(op1.getOpt());
        mcq.setOpt2(op2.getOpt());
        mcq.setOpt3(op3.getOpt());
        mcq.setOpt4(op4.getOpt());
        ModelAndView model = new ModelAndView();
        model.addObject("model",mcq);

       System.out.println("Question="+mcq.getQuest()+"\n"+"Answer="+mcq.getAns()+"\n"+"options={[option1="+mcq.getOpt1()+"]\n[option2="+mcq.getOpt2()+"]\noption3=["+mcq.getOpt3()+"]\noption4=["+mcq.getOpt4()+"]}");

         model.setViewName("display");
         return model;
    }

    @RequestMapping(value = "/showUser")
    public ModelAndView show(@RequestParam("id") int uId)
    {
        User user = userService.findUserById(uId);
        ModelAndView model = new ModelAndView();
        model.addObject("userObj",user);
        model.setViewName("userInfo");
        return model;
    }

    @RequestMapping(value = "/findAllQuestions")
    public ModelAndView showAllQ()
    {
        List<Question> questionList = questionService.getAll();
        ModelAndView model = new ModelAndView();
        model.addObject("show",questionList);
        model.setViewName("questionList");
        return model;
    }


    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteQuestion(@PathVariable("id") int qId)
    {
        questionService.deleteById(qId);
        return new ModelAndView("redirect:/findAllQuestions");
    }

    @RequestMapping(value = "/update/{id}")
    public ModelAndView questById(@ModelAttribute("id") int qId)
    {
        Question question = questionService.get(qId);
        MCQ mcq = new MCQ();

        System.out.println(question.getId());
        mcq.setId(question.getId());
        System.out.println(mcq.getId());


        String quest = question.getQuestion();
        question.setQuestion(quest);
        mcq.setQuest(question);

        mcq.setAns(question.getAnswer());

        List<Options> ops = question.getOpts();
        Options op1 = ops.get(0);
        String opts1 = op1.getOpt();
        mcq.setOpt1(opts1);

        Options op2 = ops.get(1);
        String opts2 = op2.getOpt();
        mcq.setOpt2(opts2);

        Options op3 = ops.get(2);
        String opts3 = op3.getOpt();
        mcq.setOpt3(opts3);


        Options op4 = ops.get(3);
        String opts4 = op4.getOpt();
        mcq.setOpt4(opts4);


        ModelAndView model = new ModelAndView();
        model.addObject("questById",mcq);
        model.setViewName("update");
        return model;
    }

    @RequestMapping(value = "/updateQuestion")
    public ModelAndView update(@ModelAttribute("questById") MCQ  mcq)
    {

        System.out.println(mcq.getId());
        Question question = questionService.get(mcq.getId());

        Question q = mcq.getQuest();

        question.setQuestion(q.getQuestion());


        question.getAnswer().setAnswer(mcq.getAns().getAnswer());

        List<Options> opts  = new ArrayList<Options>();
        opts = question.getOpts();

        opts.get(0).setOpt(mcq.getOpt1());
        opts.get(1).setOpt(mcq.getOpt2());
        opts.get(2).setOpt(mcq.getOpt3());
        opts.get(3).setOpt(mcq.getOpt4());

        question.setOpts(opts);


        questionService.saveQuestion(question);

        return new ModelAndView("redirect:/findAllQuestions");

    }


}
