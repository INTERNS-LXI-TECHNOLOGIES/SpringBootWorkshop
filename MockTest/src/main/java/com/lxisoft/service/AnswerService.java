package com.lxisoft.service;

import com.lxisoft.entity.*;
import com.lxisoft.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public void saveAnswer(Answer answer)
    {
    	answerRepository.save(answer);
    }

}
