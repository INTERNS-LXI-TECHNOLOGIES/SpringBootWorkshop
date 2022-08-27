package com.lxisoft.dictionary.service;

import com.lxisoft.dictionary.entity.Word;

import java.util.List;

public interface DictionaryService {

    List<Word> listAllWords(String keyword);

    void saveWord(Word word);

    void deleteWord(long id);

    Word getWord(long id);

}
