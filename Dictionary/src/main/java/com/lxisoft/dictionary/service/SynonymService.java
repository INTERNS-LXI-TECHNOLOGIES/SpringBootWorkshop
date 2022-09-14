package com.lxisoft.dictionary.service;

import com.lxisoft.dictionary.entity.Synonyms;
import com.lxisoft.dictionary.entity.Word;

import java.util.List;

public interface SynonymService {

    List<Synonyms> listAllSynonyms();
    void saveSynonym(Synonyms synonyms);

    void deleteSynonym(long synonym_id);

    Synonyms getSynonym(long synonym_id);
}
