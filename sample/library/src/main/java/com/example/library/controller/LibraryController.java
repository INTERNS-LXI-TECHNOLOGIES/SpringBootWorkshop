package com.example.library.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.model.Library;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;
//import com.example.library.service.UserService;


@Controller
public class LibraryController {

	/*private UserService userService;*/

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

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ModelAndView setBooksInUser(ModelAndView modelAndView){
        Library library = new Library();
        modelAndView.addObject("library",library);
        modelAndView.setViewName("AddUser");
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView saveBooksInUser(@ModelAttribute Library library){
        List<Book> books = new ArrayList<Book>(); 
        List<User> users = new ArrayList<User>(); 
        User user = library.getUser();
        Book book1 = library.getBook1();
        Book book2 = library.getBook2();
        Book book3 = library.getBook3();
        users.add(user);
        book1.setUsers(users);
        book2.setUsers(users);
        book3.setUsers(users);
   
        books.add(book1);
        books.add(book2);
        books.add(book3);
  
        user.setBooks(books);
        /*bookRepository.saveAll(book1,book2,book3);
        user.getBooks().addAll(book1,book2,book3);
*/
        userRepository.save(user);
        return new ModelAndView("redirect:/start");
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") long userId)
    {
        userRepository.deleteById(userId);
        bookRepository.deleteById(userId);
        return new ModelAndView("redirect:/start");
    }
   
   @GetMapping("/updateUser/{id}")
    public ModelAndView updateUser(@PathVariable("id") long userId)
    {
	   User user = userRepository.getOne(userId);

        Library library = new Library();
        
        
        library.setId(user.getId());
        library.setUser(user);
        
        List<Book> books = user.getBooks();
        Book book1 = books.get(0);
        Book book2 = books.get(1);
        Book book3 = books.get(2);
        
   
        library.setBook1(book1);
        library.setBook2(book2);
        library.setBook3(book3);
       
        
        
        ModelAndView model = new ModelAndView();
        model.addObject("library",library);
        model.setViewName("UpdateUser");
        return model;
    }

    @RequestMapping(value = "/update")
    public ModelAndView questionById(@ModelAttribute("library") Library library/*@PathVariable("id") int questId*/)
    {
        
        User user = userRepository.getOne(library.getId());
        //List<Book> books = user.getBooks() ;  
        user.setName(library.getUser().getName());
        user.setAddress(library.getUser().getAddress());
        /*
         * option1.setOption(mockExam.getOption1());
         * option2.setOption(mockExam.getOption2());
         * option3.setOption(mockExam.getOption3());
         */
        
        user.getBooks().get(0).setName(library.getBook1().getName());
        user.getBooks().get(0).setAuthor(library.getBook1().getAuthor());
        user.getBooks().get(1).setName(library.getBook2().getName());
        user.getBooks().get(1).setAuthor(library.getBook2().getAuthor());
        user.getBooks().get(2).setName(library.getBook3().getName());
        user.getBooks().get(2).setAuthor(library.getBook3().getAuthor());
        /*
         * options.add(mockExam.getOption1()); options.add(mockExam.getOption2());
         * options.add(mockExam.getOption3());
         */
        userRepository.save(user);

        return new ModelAndView("redirect:/start");
    }


   

}