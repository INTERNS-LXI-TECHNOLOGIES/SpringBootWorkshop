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
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Word word;

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

    public String getSynonym_2() {
        return synonym_2;
    }

    public void setSynonym_2 (String synonym_2) {
        this.synonym_2 = synonym_2;
    }

}
