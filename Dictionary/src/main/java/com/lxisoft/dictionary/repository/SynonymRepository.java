package com.lxisoft.dictionary.repository;
import com.lxisoft.dictionary.entity.Synonyms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SynonymRepository extends JpaRepository<Synonyms,Long> {

}
