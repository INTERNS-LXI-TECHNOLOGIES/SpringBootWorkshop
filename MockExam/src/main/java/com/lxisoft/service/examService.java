package com.lxisoft.service;

import com.lxisoft.model.Exam;
import com.lxisoft.model.User;
import com.lxisoft.repository.UserRepository;
import com.lxisoft.repository.examRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxisoft.exception.ResourceNotFoundException;
import com.lxisoft.repository.examRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class examService {
    @Autowired
    private examRepository examRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(Exam theExam) {
        examRepository.save(theExam);
    }

//    @Transactional
//    public void saveUser(User user) {
//        userRepository.save(user);
//    }

    @Transactional
    public Exam getExam(int id) throws ResourceNotFoundException {
        return examRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
    @Transactional
    public List< Exam > getExam() {
        return examRepository.findAll();
    }
    @Transactional
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Transactional
    public void deleteExam(int id)
    {
        examRepository.deleteById(id);
    }
}
