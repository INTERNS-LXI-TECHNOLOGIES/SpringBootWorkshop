package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.model.*;
import com.lxisoft.repository.*;

@Service
@Transactional
public class MockService 
{
	
	@Autowired
	private MockRepository mockRepository;
	
	@Transactional
    public void addMockQuestion(MockModel mockModel) 
    {
        mockRepository.addMockQuestion(mockModel);
    }
	
	@Transactional
    public List<MockModel> getAllQuestions() 
    {
        return mockRepository.getAllQuestions();
    }

    public void deleteQuest(Integer questionId) 
    {
	
		mockRepository.deleteQuest(questionId);
	}

    public MockModel getQuestionId(int mockid) 
	{
        return mockRepository.getQuestionId(mockid);
    }


	public MockModel getQuestion(MockModel mockModel) {
 
        return mockRepository.editQuestion(mockModel);
    }

    public MockModel editQuestion(MockModel mockModel) 
    {
	
		return mockRepository.editQuestion(mockModel);
	}
	
	

}