package com.lxisoft.service;

import com.lxisoft.entity.Student;
import com.lxisoft.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void saveQuestion(Student student)
    {
    	studentRepository.save(student);
    }

    public Student get(long id)
    {
        return studentRepository.getOne(id);
    }

    public List<Student> getAll()
    {

        return  studentRepository.findAll();
    }

    public void deleteById(long id)
    {
    	studentRepository.deleteById(id);
    }
}