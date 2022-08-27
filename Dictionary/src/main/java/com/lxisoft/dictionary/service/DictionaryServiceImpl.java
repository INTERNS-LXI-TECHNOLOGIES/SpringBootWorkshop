package com.lxisoft.dictionary.service;
import com.lxisoft.dictionary.entity.Word;
import com.lxisoft.dictionary.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Service
@Transactional
public class DictionaryServiceImpl  implements DictionaryService {

    @Autowired
    private WordRepository wordRepository;

    @Override

    public List<Word> listAllWords(String keyword) {

        if (keyword != null) {
            return wordRepository.search(keyword);
        }
        return wordRepository.findAll();
    }

    @Override
    public void saveWord(Word word) {
        wordRepository.save(word);
    }

    @Override
    public void deleteWord(long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public Word getWord(long id) {
        return wordRepository.findById(id).get();
    }

}
