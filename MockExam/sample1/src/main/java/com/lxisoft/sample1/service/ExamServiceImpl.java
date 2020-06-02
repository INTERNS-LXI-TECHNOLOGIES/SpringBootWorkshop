package com.lxisoft.sample1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.sample1.entity.Exam;
import com.lxisoft.sample1.exception.ResourceNotFoundException;
import com.lxisoft.sample1.repository.ExamRepository;

@Service
public class ExamServiceImpl {

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
}
