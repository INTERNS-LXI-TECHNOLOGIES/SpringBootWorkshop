package com.lxisoft.service;

import com.lxisoft.model.Exam;
import com.lxisoft.model.User;
import com.lxisoft.model.attendedExam;
import com.lxisoft.repository.UserRepository;
import com.lxisoft.repository.attended;
import com.lxisoft.repository.examRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxisoft.exception.ResourceNotFoundException;
import com.lxisoft.repository.examRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class examAttended {
    @Autowired
    private attended attendedExam;


    @Transactional
    public void save(attendedExam attended) {
        attendedExam.save(attended);
    }


    @Transactional
    public List<attendedExam> getAttended() {
        return attendedExam.findAll();
    }
}


