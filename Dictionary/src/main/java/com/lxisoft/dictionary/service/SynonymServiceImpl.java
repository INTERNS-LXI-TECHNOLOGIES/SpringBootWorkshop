package com.lxisoft.dictionary.service;
import com.lxisoft.dictionary.entity.Synonyms;
import com.lxisoft.dictionary.repository.SynonymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Component
@Service
@Transactional

public class SynonymServiceImpl  implements SynonymService {
    @Autowired
    private SynonymRepository synonymRepository;

    @Override
    public void saveSynonym(Synonyms synonyms) {
        synonymRepository.save(synonyms);
    }

    @Override
        public void deleteSynonym(long synonym_id) {
            synonymRepository.deleteById(synonym_id);
        }

        @Override
            public Synonyms getSynonym(long synonym_id) {
                return synonymRepository.findById(synonym_id).get();
            }

        }