package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.Exam;
import com.lxisoft.mockexam.repository.ExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamService
{
    @Autowired
    ExamRepo examRepo;

    @Transactional
    public void saveQuestion(Exam exam)
    {
        examRepo.save(exam);
    }

    @Transactional
    public void deleteQuestion(int questionId)
    {
        examRepo.deleteById(questionId);
    }

    @Transactional
    public Exam getQuestionById(int questionId)
    {
        return examRepo.getOne(questionId);
    }

    @Transactional
    public List<Exam> getExamData()
    {
        return examRepo.findAll();
    }

}
