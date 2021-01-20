package com.lxisoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Dialogue.
 */
@Entity
@Table(name = "dialogue")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Dialogue implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dialogue")
    private String dialogue;

    @ManyToOne
    @JsonIgnoreProperties(value = "dialogues", allowSetters = true)
    private Actor actor;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDialogue() {
        return dialogue;
    }

    public Dialogue dialogue(String dialogue) {
        this.dialogue = dialogue;
        return this;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public Actor getActor() {
        return actor;
    }

    public Dialogue actor(Actor actor) {
        this.actor = actor;
        return this;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dialogue)) {
            return false;
        }
        return id != null && id.equals(((Dialogue) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Dialogue{" +
            "id=" + getId() +
            ", dialogue='" + getDialogue() + "'" +
            "}";
    }
}
