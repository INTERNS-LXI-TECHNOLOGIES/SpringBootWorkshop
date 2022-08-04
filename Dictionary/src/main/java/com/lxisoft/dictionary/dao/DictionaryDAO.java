package com.lxisoft.dictionary.dao;

import com.lxisoft.dictionary.entity.Word;


import java.util.List;

public interface DictionaryDAO {

    List<Word> listAllWords();

    void saveWord(Word word);

    void deleteWord(int id);

    Word getWord(int id);

}
