package com.lxisoft.MockExam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.MockExam.model.Answer;
import com.lxisoft.MockExam.repository.AnswerRepository;

@Service
public class AnswerService {

@Autowired
    AnswerRepository answerRepository;
	
    public void saveAnswer(Answer answer)
    {
    	answerRepository.save(answer);
    }

}
