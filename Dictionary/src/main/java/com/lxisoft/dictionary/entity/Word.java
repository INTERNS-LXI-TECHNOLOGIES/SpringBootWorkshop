package com.lxisoft.dictionary.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import java.util.logging.Logger;

@Entity
@Table(name = "word")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Meaning")
    private String meaning;

    @Column(name = "Parts_Of_Speech")
    private String partsOfSpeech;

   // private static final Logger LOGGER = Logger.getLogger(Word.class.getName());

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("synonyms")
    @JoinTable(name="WordRel",
            joinColumns={@JoinColumn(name="id")},
            inverseJoinColumns={@JoinColumn(name="WordId")})
    private Set<Word> synonyms = new HashSet<Word>();

    public Word() {

    }

    public Word(String name, String meaning, String partsOfSpeech) {
        this.name = name ;
        this.meaning = meaning ;
        this.partsOfSpeech = partsOfSpeech ;
    }

    public Set<Word> getSynonyms() {
        return synonyms;
    }
    public void setSynonyms(Set<Word> synonyms) {
        this.synonyms = synonyms;
        //LOGGER.info("wordList" + synonyms);

    }

    public Word(long id, String name, String  meaning, String partsOfSpeech ) {
        this.id = id;
        this.name = name;
        this.meaning = meaning;
        this.partsOfSpeech = partsOfSpeech;

    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getPartsOfSpeech() {
        return partsOfSpeech;
    }

    public void setPartsOfSpeech(String partsOfSpeech) {
        this.partsOfSpeech = partsOfSpeech;
    }


    @Override
    public String toString() {
        return "Word {id=" + id + ",Words=" + name + ", Parts_Of_Speech=" + partsOfSpeech + ", Meanings=" + meaning + "}";
    }

}
