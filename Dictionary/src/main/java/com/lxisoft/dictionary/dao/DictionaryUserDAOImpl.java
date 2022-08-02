package com.lxisoft.dictionary.dao;
import com.lxisoft.dictionary.entity.DictionaryUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DictionaryUserDAOImpl implements DictionaryUserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public DictionaryUser getUser(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        DictionaryUser dictionaryUser = currentSession.get(DictionaryUser.class, username);
        return dictionaryUser;
    }

}

