package com.lxisoft.service;

import com.lxisoft.model.Exam;
import com.lxisoft.model.ExamChemHard;
import com.lxisoft.model.ExamHard;
import com.lxisoft.model.ExamMedium;
import com.lxisoft.repository.examChemRepositoryHard;
import com.lxisoft.repository.examRepository;
import com.lxisoft.repository.examRepositoryHard;
import com.lxisoft.repository.examRepositoryMedium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxisoft.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class examServiceChemHard {
    @Autowired
    private examChemRepositoryHard examChemRepositoryHard;


    @Transactional
    public void saveHard(ExamChemHard examHard) {
        examChemRepositoryHard.save(examHard);
    }

    @Transactional
    public ExamChemHard getExamHard(int id) throws ResourceNotFoundException {
        return examChemRepositoryHard.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<ExamChemHard> getExamHard() {
        return examChemRepositoryHard.findAll();
    }

    public void deleteExamHard(int id)
    {
        examChemRepositoryHard.deleteById(id);
    }
}
