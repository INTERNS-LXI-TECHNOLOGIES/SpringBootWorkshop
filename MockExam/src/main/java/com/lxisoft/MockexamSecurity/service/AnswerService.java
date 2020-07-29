package com.lxisoft.MockexamSecurity.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.MockexamSecurity.entity.Answer;
import com.lxisoft.MockexamSecurity.repository.AnswerRepository;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public void saveAnswer(Answer answer)
    {
    	answerRepository.save(answer);
    }

}

    