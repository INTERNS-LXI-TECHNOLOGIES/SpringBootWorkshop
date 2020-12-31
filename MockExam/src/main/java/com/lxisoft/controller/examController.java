package com.lxisoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class examController {

    @GetMapping(value = {"/", "/home"})
    public ModelAndView index()
    {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
}
