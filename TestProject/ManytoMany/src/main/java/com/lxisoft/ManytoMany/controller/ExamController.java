package com.lxisoft.ManytoMany.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.ManytoMany.dto.StudentDto;
import com.lxisoft.ManytoMany.service.StudentService;
import com.lxisoft.OnetoOneEntity.model.ExamModel;



@RestController
public class ExamController {

	@Autowired
	private StudentService studentService;
		
	@GetMapping(value="/")
	public String showSignUpForm(ExamModel exam) {
		return "first";
	}
	 @GetMapping(value = "/add")
	 public ModelAndView showAddPage(ModelAndView modelAndView){
	 ExamModel examModel = new  ExamModel();
	 modelAndView.addObject("exam",examModel);
	 modelAndView.setViewName("addstudent");
	 return modelAndView;
	}
	@GetMapping(value="/students")
	public String getAllStudent(@ModelAttribute StudentDto studentDto) {
		List<StudentDto> students = new ArrayList<>();
		studentService.getAllStudents();
		 return "add";
	}
	
    
	@GetMapping("/student")
	public String viewStudent(@ModelAttribute StudentDto studentDto) {
		StudentDto std = new StudentDto();
		studentService.addStudent(studentDto);
		return "addStudent";
	}
	
	        
	@GetMapping("/studentadd")
	public String addStudent(@ModelAttribute StudentDto studentDto) {
		StudentDto std = studentService.addStudent(studentDto);
		return "add";
	}

	@PutMapping("/studentupdate")
	public String updateEmployee(@PathVariable(name = "id") Integer id,
			@RequestBody StudentDto student) {
		StudentDto std = studentService.updateStudent(id, student);
		return "update";
	}

		
	
}

