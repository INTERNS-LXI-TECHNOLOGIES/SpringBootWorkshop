package com.lxisoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Actor.
 */
@Entity
@Table(name = "actor")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "actor_name")
    private String actorName;

    @Column(name = "ph_number")
    private String phNumber;

    @OneToOne
    @JoinColumn(unique = true)
    private Character character;

    @OneToMany(mappedBy = "actor")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Dialogue> dialogues = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "actors", allowSetters = true)
    private Movie movie;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public Actor actorName(String actorName) {
        this.actorName = actorName;
        return this;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public Actor phNumber(String phNumber) {
        this.phNumber = phNumber;
        return this;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public Character getCharacter() {
        return character;
    }

    public Actor character(Character character) {
        this.character = character;
        return this;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Set<Dialogue> getDialogues() {
        return dialogues;
    }

    public Actor dialogues(Set<Dialogue> dialogues) {
        this.dialogues = dialogues;
        return this;
    }

    public Actor addDialogue(Dialogue dialogue) {
        this.dialogues.add(dialogue);
        dialogue.setActor(this);
        return this;
    }

    public Actor removeDialogue(Dialogue dialogue) {
        this.dialogues.remove(dialogue);
        dialogue.setActor(null);
        return this;
    }

    public void setDialogues(Set<Dialogue> dialogues) {
        this.dialogues = dialogues;
    }

    public Movie getMovie() {
        return movie;
    }

    public Actor movie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Actor)) {
            return false;
        }
        return id != null && id.equals(((Actor) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Actor{" +
            "id=" + getId() +
            ", actorName='" + getActorName() + "'" +
            ", phNumber='" + getPhNumber() + "'" +
            "}";
    }
}
