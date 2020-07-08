package com.lxisoft.TestMockExam.controller;

import com.lxisoft.TestMockExam.domain.*;
import com.lxisoft.TestMockExam.model.CoursesInStudent;
import com.lxisoft.TestMockExam.model.ExamModel;
import com.lxisoft.TestMockExam.model.StudentModel;
import com.lxisoft.TestMockExam.model.StudentsInCourse;
import com.lxisoft.TestMockExam.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class TestMockController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionOptionRepository questionOptionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(value = "/")
    public String homePage(){
        return "Home";
    }

    @GetMapping(value = "/admin")
    public String adminPage(){
            return "Admin";
    }

    @GetMapping(value = "/addQuestion")
    public ModelAndView createModelForAddNewQuestion(ModelAndView modelAndView){
        ExamModel examModel = new  ExamModel();
        modelAndView.addObject("examModel",examModel);
        modelAndView.setViewName("Add");
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public String addNewQuestion(@ModelAttribute ExamModel examModel){
        List<QuestionOption> questionOptions = new ArrayList<>();
        Question question = examModel.getQuestion();
        Answer answer = examModel.getAnswer();
        answer.setQuestion(question);

        question.setAnswer(answer);

        QuestionOption option1 = new QuestionOption();
        QuestionOption option2 = new QuestionOption();
        QuestionOption option3 = new QuestionOption();
        QuestionOption option4 = new QuestionOption();

        option1.setQnOption(examModel.getOption1());
        option2.setQnOption(examModel.getOption2());
        option3.setQnOption(examModel.getOption3());
        option4.setQnOption(examModel.getOption4());

        option1.setQuestion(examModel.getQuestion());
        option2.setQuestion(examModel.getQuestion());
        option3.setQuestion(examModel.getQuestion());
        option4.setQuestion(examModel.getQuestion());

        questionOptions.add(option1);
        questionOptions.add(option2);
        questionOptions.add(option3);
        questionOptions.add(option4);

        question.setQnOption(questionOptions);

        questionRepository.save(question);

        // answerRepository.save(answer);
        //questionOptionRepository.saveAll(questionOptions);
        return "Admin";
    }

    @GetMapping(value = "/setStudentsInCourse")
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
        CoursesInStudent coursesInStudent = new CoursesInStudent();
        modelAndView.addObject("coursesInStudent",coursesInStudent);
        modelAndView.setViewName("CoursesInStudent");
        return modelAndView;
    }

    @GetMapping(value = "/saveCoursesInStudent")
    public String saveCoursesInStudent(@ModelAttribute CoursesInStudent coursesInStudent){
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

    @GetMapping(value = "/findAllQuestions")
    public ModelAndView findAllQuestions(ModelAndView modelAndView){
        List<Question> questions = questionRepository.findAll();
        modelAndView.addObject("listQuestions",questions);
        modelAndView.setViewName("View");
        return modelAndView;
    }

    @GetMapping(value = "/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable("id") int id){
        Long deleteId = (long)id;
        questionRepository.deleteById(deleteId);
    return "redirect:/findAllQuestions";
    }

    @GetMapping(value = "/setUpdate/{id}")
    public ModelAndView setUpdateQuestion(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        Question question = questionRepository.getOne(id);
        Answer answer = question.getAnswer();
        ExamModel examModel = new ExamModel();

        examModel.setId(question.getId());
        examModel.setQuestion(question);
        examModel.setAnswer(answer);
        examModel.setOption1(question.getQnOption().get(0).getQnOption());
        examModel.setOption2(question.getQnOption().get(1).getQnOption());
        examModel.setOption3(question.getQnOption().get(2).getQnOption());
        examModel.setOption4(question.getQnOption().get(3).getQnOption());

        modelAndView.addObject("updateQuestion",examModel);
        modelAndView.setViewName("Update");
        return modelAndView;
    }

    @GetMapping(value = "/updateQuestion")
    public String updateQuestion(@ModelAttribute ExamModel examModel){
        List<QuestionOption> questionOptions = new ArrayList<>();
        Question question = examModel.getQuestion();
        question.setId(examModel.getId());
        Answer answer = examModel.getAnswer();
        answer.setId(examModel.getId());
        answer.setQuestion(question);

        question.setAnswer(answer);

        QuestionOption option1 = new QuestionOption();
        QuestionOption option2 = new QuestionOption();
        QuestionOption option3 = new QuestionOption();
        QuestionOption option4 = new QuestionOption();

        option1.setQnOption(examModel.getOption1());
        option1.setId(examModel.getId());
        option2.setQnOption(examModel.getOption2());
        option2.setId(examModel.getId());
        option3.setQnOption(examModel.getOption3());
        option3.setId(examModel.getId());
        option4.setQnOption(examModel.getOption4());
        option4.setId(examModel.getId());

        option1.setQuestion(examModel.getQuestion());
        option2.setQuestion(examModel.getQuestion());
        option3.setQuestion(examModel.getQuestion());
        option4.setQuestion(examModel.getQuestion());

        questionOptions.add(option1);
        questionOptions.add(option2);
        questionOptions.add(option3);
        questionOptions.add(option4);

        question.setQnOption(questionOptions);
        //questionOptionRepository.deleteById(examModel.getId());
        questionRepository.save(question);
        questionOptionRepository.saveAll(questionOptions);
        return "Admin";
    }
}
