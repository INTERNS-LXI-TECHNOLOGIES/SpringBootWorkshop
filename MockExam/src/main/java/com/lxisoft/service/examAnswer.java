package com.lxisoft.service;

import com.lxisoft.model.Answer;
import com.lxisoft.model.Exam;
import com.lxisoft.model.User;
import com.lxisoft.repository.UserRepository;
import com.lxisoft.repository.examKey;
import com.lxisoft.repository.examRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxisoft.exception.ResourceNotFoundException;
import com.lxisoft.repository.examRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class examAnswer {
    @Autowired
    private examKey examKey;


    @Transactional
    public void save(Answer theExam) {
        examKey.save(theExam);
    }



    @Transactional
    public Answer getExam(int id) throws ResourceNotFoundException {
        return examKey.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
    @Transactional
    public List< Answer > getExam() {
        return examKey.findAll();
    }
    @Transactional
    public List<Answer> getUser() {
        return examKey.findAll();
    }

    @Transactional
    public void deleteExam(int id)
    {
        examKey.deleteById(id);
    }
}
