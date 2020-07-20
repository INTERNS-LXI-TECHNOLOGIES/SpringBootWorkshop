package com.lxisoft.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lxisoft.service.StudentService;
import com.lxisoft.dto.StudentDto;
import com.lxisoft.entity.*;
import com.lxisoft.repository.*;

@Controller
public class StudentController {

	@Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;
	
	@Autowired
	private StudentService studentService;
	 @GetMapping("/")
	    public String root() {
	        return "index";
	    }
	 
	@GetMapping(value ="/viewAll")
	public ModelAndView getAllStudents(ModelAndView modelAndView) {
		List<Student> students = studentRepository.findAll();
		modelAndView.addObject("students",students);
		modelAndView.setViewName("read");
        return modelAndView;
	}
	
	 
	
    
    @RequestMapping(value = "/newstd", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
      StudentDto studentDto = new StudentDto();
      model.addObject("studentDto", studentDto);
      model.setViewName("add");
      return model;
  }

    @GetMapping(value = "/add")
    public String saveStudents(@ModelAttribute StudentDto std){
        Course course = std.getCourse();
        Student student1 = std.getStudent1();
        Student student2 = std.getStudent2();
        Student student3 = std.getStudent3();

        courseRepository.save(course);
        studentRepository.saveAll(Arrays.asList(student1,student2,student3));
        course.getStudents().addAll(Arrays.asList(student1,student2,student3));
        courseRepository.save(course);
        return "index";
    }
	
	@PutMapping("/student/{id}")
	public ResponseEntity<StudentDto> updateEmployee(@PathVariable(name = "id") Integer id,
			@RequestBody StudentDto student) {
		StudentDto std = studentService.updateStudent(id, student);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Integer studentId) {
		String message = studentService.deleteStudent(studentId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
