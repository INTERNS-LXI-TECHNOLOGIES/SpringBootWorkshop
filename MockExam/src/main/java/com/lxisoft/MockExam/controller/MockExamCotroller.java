package com.lxisoft.MockExam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lxisoft.MockExam.service.MockExamService;

@Controller
public class MockExamCotroller {

	@Autowired	
	public MockExamService mockExamService;
	
	@GetMapping("/")
	public String viewHomePage(Model model){
		model.addAttribute("listQuestions",mockExamService.getAllQuestions());
		return "admin";
	}
}
