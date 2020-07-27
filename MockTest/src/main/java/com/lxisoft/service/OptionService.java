package com.lxisoft.service;

import com.lxisoft.entity.QnOption;
import com.lxisoft.repository.QoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    @Autowired
    QoptionRepository qoptionRepository;
    public void saveOptions(List<QnOption> options) {

    	qoptionRepository.saveAll(options);
    }
}
