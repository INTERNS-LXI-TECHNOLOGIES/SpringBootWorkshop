package com.lxisoft.MockexamSecurity.service;


import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.MockexamSecurity.model.Exam;
import com.lxisoft.MockexamSecurity.repository.ExamRepository;


@Service
public class ExamService {
	@Autowired
    private ExamRepository examRepository;

    @Transactional
    public List < Exam > getExam() {
        return examRepository.findAll();
    }
/*
 @Autowired
    private ExamRepository examRepository;

    @Transactional
    public List < Exam > getExam() {
        return examRepository.findAll();
    }

    @Transactional
    public void saveExam(Exam theExam) {
        examRepository.save(theExam);
    }

    @Transactional
    public Exam getExam(int id) throws ResourceNotFoundException {
        return examRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public void deleteExam(int theId) {
        examRepository.deleteById(theId);
    }
 */
}