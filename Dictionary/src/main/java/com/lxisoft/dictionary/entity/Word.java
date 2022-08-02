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

    private Integer id;
    @Column(name = "Words")
    private String name;

    @Column(name = "Meanings")
    private String meaning;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}