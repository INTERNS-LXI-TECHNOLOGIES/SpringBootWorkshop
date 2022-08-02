package com.lxisoft.dictionary.service;
import com.lxisoft.dictionary.dao.DictionaryDAO;
import com.lxisoft.dictionary.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class DictionaryServiceImpl  implements DictionaryService {

    @Autowired
    private DictionaryDAO dictionaryDAO;

    @Override
    @Transactional
    public List<Word> listAllWords() {
        return dictionaryDAO.listAllWords();
    }

    @Override
    @Transactional
    public void saveWord(Word word) {
        dictionaryDAO.saveWord(word);
    }

    @Override
    @Transactional
    public void deleteWord(int id) {
        dictionaryDAO.deleteWord(id);
    }

    @Override
    @Transactional
    public Word getWord(int id) {
        return dictionaryDAO.getWord(id);
    }

}
