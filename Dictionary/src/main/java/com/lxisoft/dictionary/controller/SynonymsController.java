package com.lxisoft.dictionary.controller;

import com.lxisoft.dictionary.entity.Word;
import com.lxisoft.dictionary.service.DictionaryService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SynonymsController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("Synonym/{id}")
    public String showForm(@NotNull Model model, @PathVariable long id) {
        Word word = dictionaryService.getWord(id);
        model.addAttribute("word", word);
        model.addAttribute("id",id);
        return "synonym-list";
    }

}
