package com.lxisoft.dictionary.dao;

import com.lxisoft.dictionary.entity.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Component
@Repository
    public class DictionaryDAOImpl implements DictionaryDAO {

        @Autowired
        private SessionFactory sessionFactory;

        @Override
        public List<Word> listAllWords() {
            Session session = sessionFactory.getCurrentSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Word> cq = cb.createQuery(Word.class);
            Root<Word> root = cq.from(Word.class);
            cq.select(root);
            Query<Word> query = session.createQuery(cq);
            return query.getResultList();
        }

        @Override
        public void saveWord(Word word) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.saveOrUpdate(word);
        }

        @Override
        public void deleteWord(int id) {
            Session session = sessionFactory.getCurrentSession();
            Word word = session.byId(Word.class).load(id);
            session.delete(word);
        }

        @Override
        public Word getWord(int id) {
            Session currentSession = sessionFactory.getCurrentSession();
            Word word = currentSession.get(Word.class, id);
            return word;
        }

    }

