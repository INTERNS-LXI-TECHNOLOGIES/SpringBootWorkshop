package com.lxisoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.repository.*;
import com.lxisoft.entity.*;

@Service
public class ExamService {

	 @Autowired
	 private ExamRepository examRepository;
	 
	  	@Transactional
	    public List < Exam > getAllExam() {
	        return examRepository.findAll();
	    }
	  	
	  	@Transactional
	    public void saveExam(Exam exam) {
	  		examRepository.save(exam);
	    }
	  	
	  	@Transactional
	    public void deleteExam(int question) {
	  		examRepository.deleteById(question);
	    }
	  	
	    @Transactional
	    public Optional<Exam> getExamId(int id) {
	        return examRepository.findById(id);
	    }
}