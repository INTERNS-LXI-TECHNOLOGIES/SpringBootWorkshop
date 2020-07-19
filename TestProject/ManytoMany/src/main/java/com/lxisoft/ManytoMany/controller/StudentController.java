package com.lxisoft.ManytoMany.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.ManytoMany.dto.StudentDto;
import com.lxisoft.ManytoMany.model.AnsOption;
import com.lxisoft.ManytoMany.model.Answer;
import com.lxisoft.ManytoMany.model.Question;
import com.lxisoft.ManytoMany.repository.QuestionRepository;
import com.lxisoft.ManytoMany.service.StudentService;
import com.lxisoft.OnetoOneEntity.model.ExamModel;
import com.lxisoft.ManytoMany.model.*;



@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	private QuestionRepository questionRepository;
	

	@GetMapping(value="/")
	public String showSignUpForm() {
		return "firstpage";
	}

		
	@GetMapping(value="/")
	public String showSignUpForm(ExamModel exam) {
		return "first";
	}
	@GetMapping("/students")
	public ResponseEntity<List<StudentDto>> getAllStudents() {
		List<StudentDto> students = studentService.getAllStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@PostMapping("/student")
	public ResponseEntity<StudentDto> getAllStudents(@RequestBody StudentDto studentDto) {
		StudentDto std = studentService.addStudent(studentDto);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
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

	 @GetMapping(value = "/add")
	    public ModelAndView showAddPage(ModelAndView modelAndView){
	        ExamModel examModel = new  ExamModel();
	        modelAndView.addObject("exam",examModel);
	        modelAndView.setViewName("addquestion");
	        return modelAndView;
	    }
	 @GetMapping(value = "/addNewQuestion")
	 public String addNewQuestion(@ModelAttribute ExamModel examModel){
	    	List<AnsOption> ansOptions = new ArrayList<>();
	      
	        
	    	   Question question=new Question();
		       question.setQuestion(examModel.getQuestion());
		       Answer answer=new Answer();
		       answer.setAnswer(examModel.getAnswer());
		       answer.setQuestion(question);
		       question.setAnswer(answer);
		       
		       
		     
	        AnsOption option1 = new AnsOption();
	        AnsOption option2 = new AnsOption();
	        AnsOption option3 = new AnsOption();
	        AnsOption option4 = new AnsOption();
	        
	       
	        option1.setAnsOption(examModel.getOption1());
	        option2.setAnsOption(examModel.getOption2());
	        option3.setAnsOption(examModel.getOption3());
	        option4.setAnsOption(examModel.getOption4());

	        option1.setQuestion(question);
	        option2.setQuestion(question);
	        option3.setQuestion(question);
	        option4.setQuestion(question);

	        ansOptions.add(option1);
	        ansOptions.add(option2);
	        ansOptions.add(option3);
	        ansOptions.add(option4);

	        question.setOptions(ansOptions);
	        
	        questionRepository.save(question);
	        return "first";
	    }
	 
	 @RequestMapping(value = "/findAllQuestions")
	    public ModelAndView showAllQ()
	    {
	        List<Question> questionList = questionRepository.findAll();
	        ModelAndView model = new ModelAndView();
	        model.addObject("show",questionList);
	        model.setViewName("viewExam");
	        return model;
	    }

	 @RequestMapping("update/{id}") 
	 public String updateExam(@PathVariable("id")
	 long id, Question question, BindingResult result, Model model) { if
	 (result.hasErrors()) { question.setId(id); return "update-exam"; }
	 
	 questionRepository.save(question); model.addAttribute("questions",
	 questionRepository.findAll()); return "first"; }
	
	 @GetMapping(value = "/setUpdate/{id}")
	    public ModelAndView setUpdateQuestion(@PathVariable("id") long id){
	        ModelAndView modelAndView = new ModelAndView();
	        Question question = questionRepository.getOne(id);
	        ExamModel examModel = new ExamModel();

	        examModel.setId(question.getId());
	        examModel.setQuestion(question.getQuestion());
	        examModel.setAnswer(question.getAnswer().getAnswer());
	        examModel.setOption1(question.getAnsOption().get(0).getAnsOption());
	        examModel.setOption2(question.getAnsOption().get(1).getAnsOption());
	        examModel.setOption3(question.getAnsOption().get(2).getAnsOption());
	        examModel.setOption4(question.getAnsOption().get(3).getAnsOption());

	        modelAndView.addObject("updateQuestion",examModel);
	        modelAndView.setViewName("Update");
	        return modelAndView;
	    }

	    @GetMapping(value = "/updateQuestion")
	    public String updateQuestion(@ModelAttribute ExamModel exam){
	        Question question = questionRepository.getOne(exam.getId());
	        question.setQuestion(exam.getQuestion());
	        question.getAnswer().setAnswer(exam.getAnswer());
	        question.getAnsOption().get(0).setAnsOption(exam.getOption1());
	        question.getAnsOption().get(1).setAnsOption(exam.getOption2());
	        question.getAnsOption().get(2).setAnsOption(exam.getOption3());
	        question.getAnsOption().get(3).setAnsOption(exam.getOption4());
	        questionRepository.save(question);
	        return "first";
	    }

}

