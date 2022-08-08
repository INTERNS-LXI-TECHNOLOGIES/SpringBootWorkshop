package com.lxisoft.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.dictionary.entity.DictionaryUser;

@Repository
public interface DictionaryUserRepository extends JpaRepository<DictionaryUser, String> {

}
