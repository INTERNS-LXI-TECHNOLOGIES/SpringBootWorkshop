package com.lxisoft.TestMockExam.controller;

import com.lxisoft.TestMockExam.domain.User;
import com.lxisoft.TestMockExam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestMockController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public String homePage(){
        return "Home";
    }

    @GetMapping(value = "/addUser")
    public ModelAndView addUser(ModelAndView modelAndView){
        User user = new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("Add");
        return modelAndView;
    }

    @GetMapping(value = "/addNewUser")
    public ModelAndView addNewUser(@ModelAttribute User user,ModelAndView modelAndView){
        userRepository.save(user);
        return modelAndView;
    }
}
