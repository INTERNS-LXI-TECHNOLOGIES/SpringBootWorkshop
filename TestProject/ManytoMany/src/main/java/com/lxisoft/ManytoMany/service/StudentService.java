package com.lxisoft.ManytoMany.service;

import java.util.List;

import com.lxisoft.ManytoMany.dto.StudentDto;



public interface StudentService {

	public StudentDto addStudent(StudentDto studentDto);

	public List<StudentDto> getAllStudents();

	public StudentDto updateStudent(Integer studentId, StudentDto student);

	public String deleteStudent(Integer studentId);
}