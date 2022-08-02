package com.lxisoft.dictionary.dao;

import com.lxisoft.dictionary.entity.DictionaryUser;
import org.springframework.stereotype.Component;

@Component
public interface DictionaryUserDAO {

    DictionaryUser getUser(String username);
}



