package com.lxisoft.service;

import com.lxisoft.model.Exam;
import com.lxisoft.model.ExamMedium;
import com.lxisoft.repository.examRepository;
import com.lxisoft.repository.examRepositoryMedium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxisoft.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class examServiceMedium {
    @Autowired
    private examRepositoryMedium examRepositoryMedium;


    @Transactional
    public void saveMedium(ExamMedium theExam) {
        examRepositoryMedium.save(theExam);
    }

    @Transactional
    public ExamMedium getExamMedium(int id) throws ResourceNotFoundException {
        return examRepositoryMedium.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<ExamMedium> getExamMedium() {
        return examRepositoryMedium.findAll();
    }

    public void deleteExamMedium(int id)
    {
        examRepositoryMedium.deleteById(id);
    }
}
