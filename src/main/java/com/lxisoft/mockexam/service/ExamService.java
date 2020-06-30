package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.domain.Exam;
import com.lxisoft.mockexam.repository.ExamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExamService {

    private final Logger log = LoggerFactory.getLogger(ExamService.class);

    private ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Transactional
    public void saveOrUpdateExam(Exam entity)
    {
        examRepository.save(entity);
    }

    @Transactional
    public List<Exam> getExamData()
    {

        List<Exam> examData =  examRepository.findAll();
        if(examData.size()>0)
        {
            return examData;
        }
        else
        {
            return new ArrayList<Exam>();
        }
    }

    @Transactional
    @ExceptionHandler(RecordNotFoundException.class)
    public void deleteExamById(long questionId) throws RecordNotFoundException {

        Optional<Exam> exam  = examRepository.findById(questionId);
        if(exam.isPresent())
        {
            examRepository.deleteById(questionId);
        }
        else {
            throw new RecordNotFoundException(questionId);
        }
    }

    @Transactional
    public Exam getExamById(long questionId) throws RecordNotFoundException
    {
        Optional<Exam> exam = examRepository.findById(questionId);
        if(exam.isPresent())
        {
            return exam.get();
        }
        else {
            throw new RecordNotFoundException(questionId);
        }


    }
}
