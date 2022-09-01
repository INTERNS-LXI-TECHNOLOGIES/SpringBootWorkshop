package com.lxisoft.dictionary.entity;

import javax.persistence.*;

@Table(name = "synonyms")
@Entity
public class Synonyms {
    @Id
    @Column(name = "words")
    private String words;

    @ManyToOne
    @JoinColumn(name = "id")
    private Word word;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
