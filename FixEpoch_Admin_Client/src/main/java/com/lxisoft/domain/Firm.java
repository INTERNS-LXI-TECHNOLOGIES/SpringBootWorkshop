package com.lxisoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Firm.
 */
@Entity
@Table(name = "firm")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Firm implements Serializable {

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
    private Catagorie catagorie;

    @ManyToOne
    @JsonIgnoreProperties(value = "firms", allowSetters = true)
    private Catagorie catagorie;

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

    public Firm actorName(String actorName) {
        this.actorName = actorName;
        return this;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public Firm phNumber(String phNumber) {
        this.phNumber = phNumber;
        return this;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public Catagorie getCatagorie() {
        return catagorie;
    }

    public Firm catagorie(Catagorie catagorie) {
        this.catagorie = catagorie;
        return this;
    }

    public void setCatagorie(Catagorie catagorie) {
        this.catagorie = catagorie;
    }

    public Catagorie getCatagorie() {
        return catagorie;
    }

    public Firm catagorie(Catagorie catagorie) {
        this.catagorie = catagorie;
        return this;
    }

    public void setCatagorie(Catagorie catagorie) {
        this.catagorie = catagorie;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Firm)) {
            return false;
        }
        return id != null && id.equals(((Firm) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Firm{" +
            "id=" + getId() +
            ", actorName='" + getActorName() + "'" +
            ", phNumber='" + getPhNumber() + "'" +
            "}";
    }
}
