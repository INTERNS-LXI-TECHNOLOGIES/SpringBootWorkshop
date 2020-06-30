package com.lxisoft.MockExam.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxisoft.MockExam.entity.*;
import com.lxisoft.MockExam.repository.*;

@Controller
@RequestMapping("/students/")
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

	/*
	 * @PostMapping("add") public String addExam(@Valid Exam exam,
	 * BindingResult result, Model model) { if (result.hasErrors()) { return
	 * "add-exam"; }
	 * 
	 * examRepository.save(exam); return "redirect:list"; }
	 * 
	 * @GetMapping("edit/{id}") public String showUpdateForm(@PathVariable("id")
	 * long id, Model model) { Student student = studentRepository.findById(id)
	 * .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	 * model.addAttribute("student", student); return "update-student"; }
	 * 
	 * @PostMapping("update/{id}") public String updateStudent(@PathVariable("id")
	 * long id, @Valid Student student, BindingResult result, Model model) { if
	 * (result.hasErrors()) { student.setId(id); return "update-student"; }
	 * 
	 * studentRepository.save(student); model.addAttribute("students",
	 * studentRepository.findAll()); return "index"; }
	 * 
	 * @GetMapping("delete/{id}") public String deleteStudent(@PathVariable("id")
	 * long id, Model model) { Student student = studentRepository.findById(id)
	 * .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	 * studentRepository.delete(student); model.addAttribute("students",
	 * studentRepository.findAll()); return "index"; }
	 */
	}
