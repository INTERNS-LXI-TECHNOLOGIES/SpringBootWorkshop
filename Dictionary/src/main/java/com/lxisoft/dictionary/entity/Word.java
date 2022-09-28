package com.lxisoft.dictionary.entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "dictionary")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Words")
    private String name;

    @Column(name = "Parts_Of_Speech")
    private String speech;

    @Column(name = "Meanings")
    private String meaning;

    @OneToMany(mappedBy = "word",cascade = { CascadeType.ALL } )
    private Set<Synonyms> synonym;

    public Set<Synonyms> getSynonym() {
        return synonym;
    }
        public void setSynonym(Set<Synonyms> synonym) {
            this.synonym = synonym;
        }

    public Word() {

    }

    public Word(long id, String name,String speech, String  meaning ) {
        this.id = id;
        this.name = name;
        this.speech = speech;
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

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "Word [id=" + id + ",Words=" + name + ", Parts_Of_Speech=" + speech + ", Meanings=" + meaning + " ]";
    }
}
