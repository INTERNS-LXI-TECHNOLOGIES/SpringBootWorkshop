package com.lxisoft.controller;

import com.lxisoft.entity.*;
import com.lxisoft.model.*;
import com.lxisoft.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


@Controller
public class SchoolController {

    @Autowired
    private StudentRepository studentRepository;
    

    @RequestMapping(value="/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "index";
    }

    @RequestMapping(value = "/newquestion", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
    	School school = new School();
        model.addObject("school", school);
        model.setViewName("add");
        return model;
    }
    
    @GetMapping(value = "/add")
    public String addNewQuestion(@ModelAttribute School school){
    	List<Course> courses = new ArrayList<>();
        Student student = school.getStudent();
        
        Course course1 = new Course();
        Course course2 = new Course();
        Course course3 = new Course();
        Course course4 = new Course();
        
       
        course1.setCourses(school.getCourse1());
        course2.setCourses(school.getCourse2());
        course3.setCourses(school.getCourse3());
        course4.setCourses(school.getCourse4());

        course1.setStudent(student);
        course2.setStudent(student);
        course3.setStudent(student);
        course4.setStudent(student);

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);

        student.setCourses(courses);
        
        studentRepository.save(student);
        return "index";
    }
    
    @GetMapping(value = "/viewAll")
    public ModelAndView listExam(ModelAndView model) throws IOException {
        List<Student> listExam = studentRepository.findAll();
        model.addObject("listExam", listExam);
        model.setViewName("read");
        return model;
    }
    
    
    @GetMapping(value = "/delete/{id}")
    public String deleteQuest(@PathVariable("id") int id) {
    	long schoolId = (long)id;
    	studentRepository.deleteById(schoolId);
    	return "read";   
  }
    
    
    
    
    @GetMapping(value = "/update/{id}")
    public ModelAndView updateQuestion(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        Student student = studentRepository.getOne(id);
        SchoolM schoolM = new SchoolM();

        schoolM.setId(student.getId());
        schoolM.setStudent(student.getStudent());
        schoolM.setCourse1(student.getCourses().get(0).getCourses());
        schoolM.setCourse2(student.getCourses().get(1).getCourses());
        schoolM.setCourse3(student.getCourses().get(2).getCourses());
        schoolM.setCourse4(student.getCourses().get(3).getCourses());

        modelAndView.addObject("updateQ",schoolM);
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @GetMapping(value = "/updateQ")
    public String updateQuestion(@ModelAttribute SchoolM schoolM){
        Student student = studentRepository.getOne(schoolM.getId());
        student.setStudent(schoolM.getStudent());
        student.getCourses().get(0).setCourses(schoolM.getCourse1());
        student.getCourses().get(1).setCourses(schoolM.getCourse2());
        student.getCourses().get(2).setCourses(schoolM.getCourse3());
        student.getCourses().get(3).setCourses(schoolM.getCourse4());
        studentRepository.save(student);
        return "index";
    }
}
    
  