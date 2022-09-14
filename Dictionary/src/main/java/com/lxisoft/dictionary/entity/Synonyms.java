package com.lxisoft.dictionary.entity;

import javax.persistence.*;
@Entity
@Table(name = "synonyms")

public class Synonyms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "word_id")
    private long synonym_id;

    @Column(name = "synonym_1")
    private String synonym_1;

    @Column(name = "synonym_2")
    private String synonym_2;

    @ManyToOne
    @JoinColumn(name = "id")
    private Word word;

    public long getSynonym_id() {
        return synonym_id;
    }
    public void setSynonym_id(long synonym_id) {
        this.synonym_id = synonym_id;
    }

    public String getSynonyms() {
        return synonym_1;
    }

    public void setSynonyms(String synonym_1) {
        this.synonym_1 = synonym_1;
    }

    public String getSynonym() {
        return synonym_2;
    }

    public void setSynonym (String synonym_2) {
        this.synonym_2 = synonym_2;
    }
    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
