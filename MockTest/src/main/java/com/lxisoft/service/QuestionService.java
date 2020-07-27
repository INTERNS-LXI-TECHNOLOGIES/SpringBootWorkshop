package com.lxisoft.service;

import com.lxisoft.entity.Question;
import com.lxisoft.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public void saveQuestion(Question question)
    {
    	questionRepository.save(question);
    }
}