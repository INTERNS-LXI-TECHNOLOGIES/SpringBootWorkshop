package com.lxisoft.service;

import com.lxisoft.model.Exam;
import com.lxisoft.repository.examRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxisoft.exception.ResourceNotFoundException;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class examService {
    @Autowired
    examRepository examRepository;

    @Transactional
    public void save(Exam theExam) {
        examRepository.save(theExam);
    }
//    @Transactional
//    public Exam getExam(int id) throws ResourceNotFoundException {
//        return examRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
//    }
    @Transactional
    public List< Exam > getExam() {
        return examRepository.findAll();
    }
}
