package com.lxisoft.dictionary.entity;

import javax.persistence.*;

@Table(name = "dictionary")
@Entity
public class Meaning {
    @Id
    @Column(name = "Meanings")
    private String meaning;

    @ManyToOne
    @JoinColumn(name = "Words")
    private Word word;

    public Meaning() {

    }

    public Meaning( String  meaning ) {

        this.meaning = meaning;

    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "Meaning [Meanings=" + meaning + " ]";
    }
}
