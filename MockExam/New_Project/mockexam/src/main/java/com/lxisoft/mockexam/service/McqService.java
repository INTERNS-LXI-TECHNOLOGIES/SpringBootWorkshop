package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.MCQ;
import com.lxisoft.mockexam.repo.McqRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class McqService {

    @Autowired
    McqRepo mcqRepo;

    public void saveMCQ(MCQ mcq)
    {
        mcqRepo.saveAll();
    }


}
