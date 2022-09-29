package com.lxisoft.dictionary.controller;

import com.lxisoft.dictionary.entity.Synonyms;
import com.lxisoft.dictionary.entity.Word;
import com.lxisoft.dictionary.service.DictionaryService;
import com.lxisoft.dictionary.service.SynonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SynonymsController {

    @Autowired
    private SynonymService synonymService;

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("Synonym/{id}")
    public String showForm(@PathVariable long id, Model model)  {
        Word word = dictionaryService.getWord(id);
        model.addAttribute("word",word );
        return "synonym-list";
    }

    @PostMapping("/saveSynonym/{id}")
    public String saveSynonym(@PathVariable long id,@ModelAttribute Synonyms synonym) {
        synonymService.saveSynonym(synonym);
        return "redirect:/Synonym";
    }

    @GetMapping("/createSynonym/{id}")
    public String createSynonym(@PathVariable long id, Model model) {

        model.addAttribute("synonym", new Synonyms(id));
        model.addAttribute("caption", "ADD NEW SYNONYM");

        return "synonym-form";
    }

    @GetMapping("/deleteSynonym/{id}")
    public String deleteSynonym(@PathVariable long id) {
        synonymService.deleteSynonym(id);
        return "redirect:/Synonym";
    }

    @GetMapping("/editSynonym/{id}")
    public String editSynonym(@PathVariable long id, Model model) {
        Synonyms synonym = synonymService.getSynonym(id);
        model.addAttribute("synonym", synonym);
        model.addAttribute("caption", "EDIT SYNONYM");
        return "synonym-form";
    }
}
