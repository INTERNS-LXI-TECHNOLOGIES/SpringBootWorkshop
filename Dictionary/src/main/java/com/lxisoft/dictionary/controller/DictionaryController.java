package com.lxisoft.dictionary.controller;

import com.lxisoft.dictionary.entity.Word;
import com.lxisoft.dictionary.service.DictionaryService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.logging.Logger;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    //private static final Logger LOGGER = Logger.getLogger(DictionaryController.class.getName());

    @GetMapping("/")

    public String welcome(){

        return "home";
    }

    @GetMapping("/home-result")
    public String homeResult(Model model, @Param("keyword") String keyword) {
        System.out.println("start");
        List<Word> wordsList =dictionaryService.listAllWords(keyword);
        model.addAttribute("wordsList", wordsList);
        model.addAttribute("keyword", keyword);
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model, @Param("keyword") String keyword)  {
        List<Word> wordsList =dictionaryService.listAllWords(keyword);
        model.addAttribute("wordsList", wordsList);
        model.addAttribute("keyword", keyword);

       // LOGGER.info("wordList" + wordsList);
        return "data-list";
    }

    @PostMapping("/save/{id}")
    public String updateWord(@PathVariable long id,@ModelAttribute Word word) {
        Word w = dictionaryService.getWord(id);
        word.setSynonyms(w.getSynonyms());
        dictionaryService.saveWord(word);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public String createWord(Model model) {

        model.addAttribute("word", new Word());
        model.addAttribute("caption", "ADD NEW WORD");

        return "data-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteWord(@PathVariable long id) {
        dictionaryService.deleteWord(id);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String editWord(@PathVariable long id, Model model) {
        Word word = dictionaryService.getWord(id);
        model.addAttribute("word", word);
        model.addAttribute("caption", "EDIT WORD");
        return "data-form";
    }

    @GetMapping("Synonym/{id}")
    public String showForm(@NotNull Model model, @PathVariable long id) {
        Word word = dictionaryService.getWord(id);
        model.addAttribute("word", word);
        model.addAttribute("id",id);
        return "synonym-list";
    }

    @GetMapping("/createSynonym/{id}")
    public String createSynonym(@PathVariable long id, Model model , @Param("keyword") String keyword) {
        Word word = dictionaryService.getWord(id);
        model.addAttribute("word", word);
        List<Word> wordsList =dictionaryService.listAllWords(keyword);
        model.addAttribute("wordsList", wordsList);
        model.addAttribute("keyword", keyword);

        return "synonym-form";
    }

    @PostMapping("/saveSynonym/{id}")
    public String saveWord(@PathVariable long id ,@RequestParam ("synonyms") Word synonym){
        Word w = dictionaryService.getWord(id);
        w.getSynonyms().add(synonym);
        //LOGGER.info("saving word: "+ w);
        dictionaryService.saveWord(w);
        return "redirect:/Synonym/" + id;
    }

    @GetMapping("/Login-form")
    public String login() {
        return "Login-form";
    }
}
