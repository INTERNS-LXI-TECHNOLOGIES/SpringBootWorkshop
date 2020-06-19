package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.dao.*;
import com.lxisoft.entity.*;

@Service
public class MockService {

	 @Autowired
	 private MockRepository mockRepository;
	 
	  	@Transactional
	    public List < MockEntity > getAllQuestions() {
	        return mockRepository.findAll();
	    }
	  	
	  	@Transactional
	    public void saveQuestion(MockEntity mockEntity) {
	  		mockRepository.save(mockEntity);
	    }
	  	
	  	@Transactional
	    public void deleteQuestion(int question) {
	  		mockRepository.deleteById(question);
	    }
}