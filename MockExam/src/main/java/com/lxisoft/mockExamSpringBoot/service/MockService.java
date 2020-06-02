package com.lxisoft.mockExamSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.mockExamSpringBoot.dao.*;
import com.lxisoft.mockExamSpringBoot.entity.*;

@Service
public class MockService {
	
	@Autowired
	MockDao mockDao;
	
	@Transactional
    public List < MockEntity > getAllQuestions() {
        return mockDao.findAll();
    }
	
	@Transactional
    public void saveQuestion(MockEntity mockEntity) {
        mockDao.save(mockEntity);
    }
	
	@Transactional
    public void deleteQuestion(int question) {
        mockDao.deleteById(question);
    }
	
	@Transactional
    public Optional<MockEntity> getQuestionId(int id) {
        return mockDao.findById(id); 
    }

}
