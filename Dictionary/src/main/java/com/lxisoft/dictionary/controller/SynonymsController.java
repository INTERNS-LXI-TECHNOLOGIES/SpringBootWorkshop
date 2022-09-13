package com.lxisoft.dictionary.controller;

import com.lxisoft.dictionary.service.SynonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SynonymsController {

    @Autowired
    private SynonymService synonymService;
    


}
