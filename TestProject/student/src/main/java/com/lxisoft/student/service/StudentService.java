package com.lxisoft.student.service;

import java.util.List;

import com.lxisoft.student.dto.StudentModel;



public interface StudentService {

	public StudentModel addStudent(StudentModel studentDto);

	public List<StudentModel> getAllStudents();

	public StudentModel updateStudent(Integer studentId, StudentModel student);

	public String deleteStudent(Integer studentId);
}