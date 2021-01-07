package com.lxisoft.service;

import com.lxisoft.model.Exam;
import com.lxisoft.model.ExamHard;
import com.lxisoft.model.ExamMedium;
import com.lxisoft.repository.examRepository;
import com.lxisoft.repository.examRepositoryHard;
import com.lxisoft.repository.examRepositoryMedium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxisoft.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class examServiceHard {
    @Autowired
    private examRepositoryHard examRepositoryHard;


    @Transactional
    public void saveHard(ExamHard examHard) {
        examRepositoryHard.save(examHard);
    }

    @Transactional
    public ExamHard getExamHard(int id) throws ResourceNotFoundException {
        return examRepositoryHard.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<ExamHard> getExamHard() {
        return examRepositoryHard.findAll();
    }

    public void deleteExamHard(int id)
    {
        examRepositoryHard.deleteById(id);
    }
}
