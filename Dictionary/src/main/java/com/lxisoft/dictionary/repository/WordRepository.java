package com.lxisoft.dictionary.repository;

import com.lxisoft.dictionary.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    @Query("SELECT word FROM Word word WHERE CONCAT(word.name, ' ', word.partsOfSpeech, ' ', word.meaning) LIKE %?1%")

    public List<Word> search(String keyword);
}