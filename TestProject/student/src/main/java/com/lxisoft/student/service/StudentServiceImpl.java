package com.lxisoft.student.service;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.lxisoft.student.dto.StudentModel;
import com.lxisoft.student.entity.Course;
import com.lxisoft.student.entity.Student;
import com.lxisoft.student.repository.CourseRepository;
import com.lxisoft.student.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentRepository studentRepository;

	@Resource
	private CourseRepository courseRepository;

	@Transactional
	@Override
	public StudentModel addStudent(StudentModel studentDto) {
		Student student = new Student();
		mapDtoToEntity(studentDto, student);
		Student savedStudent = studentRepository.save(student);
		return mapEntityToDto(savedStudent);
	}

	@Override
	public List<StudentModel> getAllStudents() {
		List<StudentModel> studentDtos = new ArrayList<>();
		List<Student> students = studentRepository.findAll();
		students.stream().forEach(student -> {
			StudentModel studentDto = mapEntityToDto(student);
			studentDtos.add(studentDto);
		});
		return studentDtos;
	}

	@Transactional
	@Override
	public StudentModel updateStudent(Integer id, StudentModel studentDto) {
		Student std = studentRepository.getOne(id);
		std.getCourses().clear();
		mapDtoToEntity(studentDto, std);
		Student student = studentRepository.save(std);
		return mapEntityToDto(student);
	}

	@Override
	public String deleteStudent(Integer studentId) {
		
		Student student = studentRepository.getOne(studentId);
		//Remove the related courses from student entity.
		student.removeCourses();
		studentRepository.deleteById(studentId);
		return "Student with id: " + studentId + " deleted successfully!";
	}

	private void mapDtoToEntity(StudentModel studentDto, Student student) {
		student.setName(studentDto.getName());
		if (null == student.getCourses()) {
			student.setCourses(new HashSet<>());
		}
		studentDto.getCourses().stream().forEach(courseName -> {
			Course course = courseRepository.findByName(courseName);
			if (null == course) {
				course = new Course();
				course.setStudents(new HashSet<>());
			}
			course.setName(courseName);
			student.addCourse(course);
		});
	}

	private StudentModel mapEntityToDto(Student student) {
		StudentModel responseDto = new StudentModel();
		responseDto.setName(student.getName());
		responseDto.setId(student.getId());
		responseDto.setCourses(student.getCourses().stream().map(Course::getName).collect(Collectors.toSet()));
		return responseDto;
	}
}