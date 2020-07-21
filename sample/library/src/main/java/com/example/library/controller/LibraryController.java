package com.example.library.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;


import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.model.Library;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;


@Controller
public class LibraryController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/")
    public String homePage(){
        return "Home";
    }

     @GetMapping(value = "/start")
    public ModelAndView findAllUserBooks(ModelAndView modelAndView){
        List<User> users = userRepository.findAll();
        modelAndView.addObject("listUser",users);
        modelAndView.setViewName("Index");
        return modelAndView;
    }

    @GetMapping(value = "/admin")
    public String adminPage(){
            return "Admin";
    }

    /*@GetMapping(value = "/setStudentsInCourse")
    public ModelAndView setStudentsInCourse(ModelAndView modelAndView){
        StudentsInCourse studentsInCourse = new StudentsInCourse();
        modelAndView.addObject("setStudentsInCourse",studentsInCourse);
        modelAndView.setViewName("StudentsInCourse");
        return modelAndView;
    }

    @GetMapping(value = "/saveStudentsInCourse")
    public String saveStudentsInCourse(@ModelAttribute StudentsInCourse studentsInCourse){
        Course course = studentsInCourse.getCourse();
        Student student1 = studentsInCourse.getStudent1();
        Student student2 = studentsInCourse.getStudent2();
        Student student3 = studentsInCourse.getStudent3();
        courseRepository.save(course);

        studentRepository.saveAll(Arrays.asList(student1,student2,student3));

        course.getStudents().addAll(Arrays.asList(student1,student2,student3));

        courseRepository.save(course);

        return "Admin";
    }*/

    @GetMapping(value = "/addUser")
    public ModelAndView setBooksInUser(ModelAndView modelAndView){
        Library library = new Library();
        modelAndView.addObject("library",library);
        modelAndView.setViewName("AddUser");
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public String saveCoursesInStudent(@ModelAttribute Library library){
        User user = library.getUser();
        Book book1 = library.getBook1();
        Book book2 = library.getBook2();
        Book book3 = library.getBook3();

        userRepository.save(user);

        bookRepository.saveAll(Arrays.asList(book1,book2,book3));
        user.getBooks().addAll(Arrays.asList(book1,book2,book3));

        userRepository.save(user);

        return "Index";
    }


   /* @GetMapping(value = "/setStudent")
    public ModelAndView setStudent(ModelAndView modelAndView){
        StudentModel studentModel = new StudentModel();
        modelAndView.addObject("student",studentModel);
        modelAndView.setViewName("AddStudent");
        return modelAndView;
    }

    @GetMapping(value = "/addNewStudent")
    public String addNewStudent(@ModelAttribute StudentModel studentModel){
        Student student = studentModel.getStudent();
        Course course = studentModel.getCourse();

        studentRepository.save(student);

        courseRepository.saveAll(Arrays.asList(course));

        student.getCourses().addAll(Arrays.asList(course));

        studentRepository.save(student);

        return "Admin";
    }*/


   

}