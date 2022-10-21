package com.lxisoft.dictionary.entity;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "word")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Parts_Of_Speech")
    private String partsOfSpeech;

    @Column(name = "Meaning")
    private String meaning;
    public Word() {

    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="WordRel",
            joinColumns={@JoinColumn(name="id")},
            inverseJoinColumns={@JoinColumn(name="WordId")})
    private Set<Word> synonyms = new HashSet<Word>();


    public Set<Word> getSynonyms() {
        return synonyms;
    }
    public void setSynonyms(Set<Word> synonyms) {
        this.synonyms = synonyms;
    }

    public Word(long id, String name, String partsOfSpeech, String  meaning ) {
        this.id = id;
        this.name = name;
        this.partsOfSpeech = partsOfSpeech;
        this.meaning = meaning;

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

    public String getPartsOfSpeech() {
        return partsOfSpeech;
    }

    public void setPartsOfSpeech(String partsOfSpeech) {
        this.partsOfSpeech = partsOfSpeech;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    /*@Override
    public String toString() {
        return "Word [id=" + id + ",Words=" + name + ", Parts_Of_Speech=" + speech + ", Meanings=" + meaning + " ]";
    }*/
}
