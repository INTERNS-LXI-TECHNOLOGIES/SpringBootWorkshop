package com.lxisoft.MockExam.controller;



import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxisoft.MockExam.entity.*;
import com.lxisoft.MockExam.repository.*;

@Controller
@RequestMapping("/exams/")
public class ExamController {

	private final ExamRepository examRepository;

	@Autowired
	public ExamController(ExamRepository examRepository) {
		this.examRepository = examRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Exam exam) {
		return "add-exam";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("exams", examRepository.findAll());
		return "index";
	}

	@PostMapping("add")
	public String addStudent(Exam exam,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-exam";
		}

		examRepository.save(exam);
		return "redirect:list";
	}
	
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Exam exam = examRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid exam Id:" + id));
		model.addAttribute("exam", exam);
		return "update-exam";
	}

	 @PostMapping("update/{id}") public String updateExam(@PathVariable("id")
	 long id, Exam exam, BindingResult result, Model model) { if
	 (result.hasErrors()) { exam.setId(id); return "update-exam"; }
	 
	 examRepository.save(exam); model.addAttribute("exams",
	 examRepository.findAll()); return "index"; }
	
	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		Exam exam = examRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid exam Id:" + id));
		examRepository.delete(exam);
		model.addAttribute("exams", examRepository.findAll());
		return "index";
	}
}
