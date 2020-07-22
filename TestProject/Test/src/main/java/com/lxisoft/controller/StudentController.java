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
    
    @RequestMapping(value = "/newcrs", method = RequestMethod.GET)
    public ModelAndView newCourse(ModelAndView model) {
      StudentDto studentDto = new StudentDto();
      model.addObject("studentDto", studentDto);
      model.setViewName("addcourse");
      return model;
  }

    @GetMapping(value = "/addcourse")
    public String saveCoursesInStudent(@ModelAttribute StudentDto std){
        Student student = std.getStudent();
        Course course1 = std.getCourse1();
        Course course2 = std.getCourse2();
        Course course3 = std.getCourse3();

        studentRepository.save(student);
        courseRepository.saveAll(Arrays.asList(course1,course2,course3));
        student.getCourses().addAll(Arrays.asList(course1,course2,course3));
        studentRepository.save(student);
        return "index";
    }
    
    
    @GetMapping(value = "update/{id}")
	public String updateEmployee(@PathVariable(name = "id") Integer id,
			 StudentDto student) {
		StudentDto std = studentService.updateStudent(id, student);
		return "update";
	}
}
