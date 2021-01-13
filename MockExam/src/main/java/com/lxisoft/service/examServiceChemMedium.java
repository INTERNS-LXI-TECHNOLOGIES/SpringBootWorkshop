package com.lxisoft.service;

import com.lxisoft.model.Exam;
import com.lxisoft.model.ExamChemMedium;
import com.lxisoft.model.ExamMedium;
import com.lxisoft.repository.examRepository;
import com.lxisoft.repository.examRepositoryChemMedium;
import com.lxisoft.repository.examRepositoryMedium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxisoft.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class examServiceChemMedium {
    @Autowired
    private com.lxisoft.repository.examRepositoryChemMedium examRepositoryChemMedium;


    @Transactional
    public void saveMedium(ExamChemMedium theExam) {
        examRepositoryChemMedium.save(theExam);
    }

    @Transactional
    public ExamChemMedium getExamMedium(int id) throws ResourceNotFoundException {
        return examRepositoryChemMedium.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<ExamChemMedium> getExamMedium() {
        return examRepositoryChemMedium.findAll();
    }

    public void deleteExamMedium(int id)
    {
        examRepositoryChemMedium.deleteById(id);
    }
}
