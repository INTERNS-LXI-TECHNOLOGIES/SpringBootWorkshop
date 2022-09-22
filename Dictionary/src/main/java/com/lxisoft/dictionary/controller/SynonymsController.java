package com.lxisoft.dictionary.controller;

import com.lxisoft.dictionary.entity.Synonyms;
import com.lxisoft.dictionary.entity.Word;
import com.lxisoft.dictionary.service.DictionaryService;
import com.lxisoft.dictionary.service.SynonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SynonymsController {

    @Autowired
    private SynonymService synonymService;

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("showSynonymForm/{id}")
    public String showForm(@PathVariable long id, Model model)  {
        Word word = dictionaryService.getWord(id);
        model.addAttribute("word",word );
        return "synonym-list";
    }

    @PostMapping("/saveSynonym")
    public String saveSynonym(@ModelAttribute Synonyms synonyms) {
        synonymService.saveSynonym(synonyms);
        return "redirect:/showSynonymForm";
    }

    @GetMapping("/createSynonym")
    public String createSynonym(Model model) {

        model.addAttribute("synonym", new Synonyms());
        model.addAttribute("caption", "ADD NEW SYNONYM");

        return "synonym-form";
    }

    @GetMapping("/deleteSynonym/{synonym_id}")
    public String deleteSynonym(@PathVariable long synonym_id) {
        synonymService.deleteSynonym(synonym_id);
        return "redirect:/showSynonymForm";
    }

    @GetMapping("/editSynonym/{synonym_id}")
    public String editSynonym(@PathVariable long synonym_id, Model model) {
        Synonyms synonyms = synonymService.getSynonym(synonym_id);
        model.addAttribute("synonym", synonyms);
        model.addAttribute("caption", "EDIT SYNONYM");
        return "synonym-form";
    }
}
