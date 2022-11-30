package com.lxisoft.dictionary.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.lxisoft.dictionary.CSVHelper;
import com.lxisoft.dictionary.entity.Word;
import com.lxisoft.dictionary.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class CSVService {
    @Autowired
    WordRepository repository;

    public void save(MultipartFile file) {
        try {
            Set<Word> word = CSVHelper.csvToWords(file.getInputStream());
            repository.saveAll(word);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Word> word = repository.findAll();

        ByteArrayInputStream in = CSVHelper.wordsToCSV((Set<Word>) word);
        return in;
    }

    public List<Word> getAllWords() {
        return repository.findAll();
    }
}

