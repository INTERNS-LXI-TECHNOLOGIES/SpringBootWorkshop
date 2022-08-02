package com.lxisoft.dictionary.service;

import com.lxisoft.dictionary.entity.Word;

import java.util.List;

public interface DictionaryService {

    List<Word> listAllWords();

    void saveWord(Word word);

    void deleteWord(int id);

    Word getWord(int id);

}
