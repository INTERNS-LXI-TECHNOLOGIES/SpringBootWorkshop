package com.lxisoft.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.repository.MockRepository;
import com.lxisoft.entity.MockEntity;

@Service
public class MockService {

	 @Autowired
	 MockRepository mockRepository;
	 
	  	@Transactional
	    public List < MockEntity > getAllQuestions() 
	    {
	        return mockRepository.findAll();
	    }
	  	
	  	@Transactional
	    public void saveQuestion(MockEntity mockEntity) 
	    {
	  		mockRepository.save(mockEntity);
	    }
	  	
	  	@Transactional
	    public void deleteQuestion(int question) 
	    {
	  		mockRepository.deleteById(question);
	    }

	     @Transactional
	    public Optional<MockEntity> getQuestionId(int id) 
	    {
	        return mockRepository.findById(id);
	    }
	  
}