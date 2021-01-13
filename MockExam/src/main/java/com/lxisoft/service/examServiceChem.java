package com.lxisoft.service;

import com.lxisoft.model.Exam;
import com.lxisoft.model.ExamChem;
import com.lxisoft.repository.examChemRepository;
import com.lxisoft.repository.examRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxisoft.exception.ResourceNotFoundException;
import com.lxisoft.repository.examRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class examServiceChem {
    @Autowired
    private examChemRepository examChemRepository;

    @Transactional
    public void save(ExamChem theExam) {
        examChemRepository.save(theExam);
    }
    @Transactional
    public ExamChem getExam(int id) throws ResourceNotFoundException {
        return examChemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
    @Transactional
    public List< ExamChem > getExam() {
        return examChemRepository.findAll();
    }

    @Transactional
    public void deleteExam(int id)
    {
        examChemRepository.deleteById(id);
    }
}
