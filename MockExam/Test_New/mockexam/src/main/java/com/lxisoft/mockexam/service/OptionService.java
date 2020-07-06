package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.Options;
import com.lxisoft.mockexam.repo.OptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    @Autowired
    OptionRepo optionRepo;
    public void saveOptions(List<Options> options) {

        optionRepo.saveAll(options);
    }
}
