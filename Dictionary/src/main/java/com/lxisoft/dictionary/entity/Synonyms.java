package com.lxisoft.dictionary.entity;

import javax.persistence.*;
@Entity
@Table(name = "synonyms")

public class Synonyms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "synonym_id")
    private long synonym_id;


    @Column(name = "synonym_1")
    private String synonym_1;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Word word;
    private  long id;

    public Synonyms() {
    }

    public Synonyms(long id) {

    }

    public long getSynonym_id() {
        return synonym_id;
    }
    public void setSynonym_id(long synonym_id) {
        this.synonym_id = synonym_id;
    }

    public String getSynonym_1() {
        return synonym_1;
    }

    public void setSynonym_1(String synonym_1) {
        this.synonym_1 = synonym_1;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Word getWord() {
        return word;
    }
    public void setWord(Word word) {
        this.word = word;
    }

}
