package com.lxisoft.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Character.
 */
@Entity
@Table(name = "jhi_character")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Character implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "character_name")
    private String characterName;

    @Column(name = "character_type")
    private String characterType;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public Character characterName(String characterName) {
        this.characterName = characterName;
        return this;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterType() {
        return characterType;
    }

    public Character characterType(String characterType) {
        this.characterType = characterType;
        return this;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Character)) {
            return false;
        }
        return id != null && id.equals(((Character) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Character{" +
            "id=" + getId() +
            ", characterName='" + getCharacterName() + "'" +
            ", characterType='" + getCharacterType() + "'" +
            "}";
    }
}
