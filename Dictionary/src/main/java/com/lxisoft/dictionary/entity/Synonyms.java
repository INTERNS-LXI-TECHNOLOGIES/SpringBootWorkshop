package com.lxisoft.dictionary.entity;

import javax.persistence.*;

@Table(name = "synonyms")
@Entity
public class Synonyms {
    @Id
    @Column(name = "synonym_1")
    private String synonym_1;

    @Column(name = "synonym_2")
    private String synonym_2;

    @ManyToOne
    @JoinColumn(name = "id")
    private Word word;

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
