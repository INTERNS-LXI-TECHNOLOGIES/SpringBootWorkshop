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
        Word word = dictionaryService.getWord(id);
        synonym.setWord(word);
        synonymService.saveSynonym(synonym);
        return "redirect:/Synonym/" + id;
    }

    @GetMapping("/createSynonym/{id}")
    public String createSynonym(@PathVariable long id, Model model) {

        model.addAttribute("synonym", new Synonyms(id));
        model.addAttribute("caption", "ADD NEW SYNONYM");

        return "synonym-form";
    }

    @GetMapping("/deleteSynonym/{synonym_id}/word/{id}")
    public String deleteSynonym(@PathVariable(value = "synonym_id") long synonym_id,@PathVariable(value = "id") long id) {
        synonymService.deleteSynonym(synonym_id);
        return "redirect:/Synonym/" + id;
    }

    @GetMapping("/editSynonym/{synonym_id}/word/{id}")
    public String editSynonym(@PathVariable(value = "synonym_id") long synonym_id, Model model,@PathVariable(value = "id") long id) {
        Synonyms synonym = synonymService.getSynonym(synonym_id);
        model.addAttribute("synonym", synonym);
        model.addAttribute("caption", "EDIT SYNONYM");
        return "synonym-form";
    }
}
