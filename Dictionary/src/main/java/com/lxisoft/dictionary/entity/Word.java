package com.lxisoft.dictionary.entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.*;
@Table(name = "dictionary")
@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;

    @Column(name = "Words")
    private String name;

    @Column(name = "Meanings")
    private String meaning;

    @Column(name = "Parts_Of_Speech")
    private String speech;

    @Column(name = "Synonyms")
    private String synonyms;

    public Word() {

    }

    public Word(long id, String name, String  meaning, String speech , String synonyms) {
        this.id = id;
        this.name = name;
        this.meaning = meaning;
        this.speech = speech;
        this.synonyms = synonyms;
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

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }

    @Override
    public String toString() {
        return "Word [id=" + id + ",Words=" + name + ", Meanings=" + meaning + ", Parts_Of_Speech=" + speech + " , Synonyms =" + synonyms + " ]";
    }
}
