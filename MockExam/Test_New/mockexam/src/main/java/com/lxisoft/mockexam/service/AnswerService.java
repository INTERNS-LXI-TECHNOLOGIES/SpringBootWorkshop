package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.Answer;
import com.lxisoft.mockexam.entity.Question;
import com.lxisoft.mockexam.repo.AnswerRepo;
import com.lxisoft.mockexam.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    AnswerRepo answerRepo;

    public void saveAnswer(Answer answer)
    {
        answerRepo.save(answer);
    }

}
