package com.lxisoft.dictionary.service;

import com.lxisoft.dictionary.entity.Synonyms;


import java.util.List;

public interface SynonymService {

    void saveSynonym(Synonyms synonyms);

    void deleteSynonym(long synonym_id);

    Synonyms getSynonym(long synonym_id);
}
