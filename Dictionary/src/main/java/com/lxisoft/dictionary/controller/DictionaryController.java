package com.lxisoft.dictionary.controller;

import com.lxisoft.dictionary.entity.Word;
import com.lxisoft.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    private static final Logger LOGGER = Logger.getLogger(DictionaryController.class.getName());

    @GetMapping("/")

    public String home(Model model)  {
        List<Word> wordsList =dictionaryService.listAllWords();
        model.addAttribute("wordsList", wordsList);

        LOGGER.info("wordList" + wordsList);
        return "data-list";
    }

    @PostMapping("/save")
    public String saveWord(@ModelAttribute Word word) {
        dictionaryService.saveWord(word);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String createWord(Model model) {

        model.addAttribute("word", new Word());
        model.addAttribute("caption", "ADD NEW WORD");

        return "data-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteWord(@PathVariable int id) {
        dictionaryService.deleteWord(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editWord(@PathVariable int id, Model model) {
        Word word = dictionaryService.getWord(id);
        model.addAttribute("word", word);
        model.addAttribute("caption", "EDIT WORD");
        return "data-form";
    }
    @GetMapping("/Login-form")
    public String login() {
        return "Login-form";
    }
}



