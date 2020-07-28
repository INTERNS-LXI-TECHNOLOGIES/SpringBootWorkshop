package com.lxisoft.service;

import com.lxisoft.entity.Question;
import com.lxisoft.repository.QuestionRepository;

import java.util.List;

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
    public Question get(long id)
    {
        return questionRepository.getOne(id);
    }

    public List<Question> getAll()
    {

        return  questionRepository.findAll();
    }

    public long deleteById(long id)
    {
    	questionRepository.deleteById(id);
    	return id;
    }
    
}