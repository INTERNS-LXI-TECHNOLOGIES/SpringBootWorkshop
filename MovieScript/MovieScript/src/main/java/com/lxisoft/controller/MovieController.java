package com.lxisoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MovieController {

    System.out.();

    @RequestMapping("/")
    public String hello()
    {
        return "hello world Welcome";
    }

    @GetMapping(value ="/home")
    public String indexPage() {
        return "intro";
    }

    @GetMapping(value = "/adminpage")
    public String adminPage() {
        return "admin";
    }

}