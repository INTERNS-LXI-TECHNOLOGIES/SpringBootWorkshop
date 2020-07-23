package com.lxisoft.MockExamProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExamController {

    

    @GetMapping(value = "/")
    public String homePage(){
        return "Home";
    }
}
