package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.Question;
import com.lxisoft.mockexam.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public void saveQuestion(Question question)
    {
            questionRepo.save(question);
    }
}
