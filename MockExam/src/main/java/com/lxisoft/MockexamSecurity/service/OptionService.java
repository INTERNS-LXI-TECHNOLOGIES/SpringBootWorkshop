package com.lxisoft.MockexamSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.MockexamSecurity.entity.AnsOption;
import com.lxisoft.MockexamSecurity.repository.AnsOptionRepository;

import java.util.List;

@Service
public class OptionService {

    @Autowired
    AnsOptionRepository ansOptionRepository;
    public void saveOptions(List<AnsOption> options) {

    	ansOptionRepository.saveAll(options);
    }
}