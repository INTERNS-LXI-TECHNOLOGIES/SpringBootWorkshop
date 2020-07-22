package com.lxisoft.student.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.ManytoMany.model.CoursesInStudent;
import com.lxisoft.ManytoMany.model.StudentsInCourse;
import com.lxisoft.student.dto.StudentModel;
import com.lxisoft.student.entity.Course;
import com.lxisoft.student.entity.Student;
import com.lxisoft.student.service.StudentService;
import com.lxisoft.student.repository.CourseRepository;
import com.lxisoft.student.repository.StudentRepository;


@Controller
public class StudentController {

	@Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String firstPage() {
	return "first";
	}
	 
	/*@GetMapping(value ="/viewAll")
	public ModelAndView getAllStudents(ModelAndView modelAndView) {
		List<Student> students = studentRepository.findAll();
		modelAndView.addObject("students",students);
		modelAndView.setViewName("view");
        return modelAndView;
	}
		
    
    @RequestMapping(value = "/newstudent", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
      StudentModel studentDto = new StudentModel();
      model.addObject("studentDto", studentDto);
      model.setViewName("add");
      return model;
  }

    @GetMapping(value = "/add")
    public String saveStudents(@ModelAttribute StudentModel std){
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
	
	/*@PutMapping("/student/{id}")
	public ResponseEntity<StudentDto> updateEmployee(@PathVariable(name = "id") Integer id,
			@RequestBody StudentDto student) {
		StudentDto std = studentService.updateStudent(id, student);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Integer studentId) {
		String message = studentService.deleteStudent(studentId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	} */
	@GetMapping(value = "/setStudentsInCourse")
    public ModelAndView setStudentsInCourse(ModelAndView modelAndView){
        Course studentsInCourse = new Course();
        modelAndView.addObject("setStudentsInCourse",studentsInCourse);
        modelAndView.setViewName("StudentInCourse");
        return modelAndView;
    }

    @GetMapping(value = "/saveStudentsInCourse")
    public String saveStudentsInCourse(@ModelAttribute StudentsInCourse studentsInCourse){
        Course course = studentsInCourse.getCourse();
        Student student1 = studentsInCourse.getStudent1();
        Student student2 = studentsInCourse.getStudent2();
        Student student3 = studentsInCourse.getStudent3();
        //Student student4 = studentsInCourse.getStudent4();
       // Student student5 = studentsInCourse.getStudent5();

        courseRepository.save(course);

        studentRepository.saveAll(Arrays.asList(student1,student2,student3));

        course.getStudents().addAll(Arrays.asList(student1,student2,student3));

        courseRepository.save(course);

        return "Admin";
    }

    @GetMapping(value = "/setCoursesInStudent")
    public ModelAndView setCoursesInStudent(ModelAndView modelAndView){
        CourseModel coursesInStudent = new CourseModel();
        modelAndView.addObject("coursesInStudent",coursesInStudent);
        modelAndView.setViewName("CourseInStudent");
        return modelAndView;
    }

    @GetMapping(value = "/saveCoursesInStudent")
    public String saveCoursesInStudent(@ModelAttribute CourseModel coursesInStudent){
        Student student = coursesInStudent.getStudent();
        Course course1 = coursesInStudent.getCourse1();
        Course course2 = coursesInStudent.getCourse2();
        Course course3 = coursesInStudent.getCourse3();

        studentRepository.save(student);

        courseRepository.saveAll(Arrays.asList(course1,course2,course3));
        student.getCourses().addAll(Arrays.asList(course1,course2,course3));

        studentRepository.save(student);

        return "Admin";
    }


    @GetMapping(value = "/setStudent")
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
    }


    @GetMapping(value = "/findAllStudentCourses")
    public ModelAndView findAllStudentCourses(ModelAndView modelAndView){
        List<Student> students = studentRepository.findAll();
        modelAndView.addObject("listStudent",students);
        modelAndView.setViewName("ViewStudentCourses");
        return modelAndView;
    }
}