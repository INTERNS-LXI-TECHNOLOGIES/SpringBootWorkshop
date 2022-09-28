package com.lxisoft.dictionary.service;

import com.lxisoft.dictionary.entity.Synonyms;


import java.util.List;

public interface SynonymService {

    void saveSynonym(Synonyms synonym);

    void deleteSynonym(long id);

    Synonyms getSynonym(long id);
}
