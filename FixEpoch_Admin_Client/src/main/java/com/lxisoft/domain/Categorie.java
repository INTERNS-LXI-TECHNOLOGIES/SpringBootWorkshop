package com.lxisoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Categorie.
 */
@Entity
@Table(name = "categorie")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "detail", nullable = false)
    private String detail;

    @OneToMany(mappedBy = "name")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Firm> firms = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "categories", allowSetters = true)
    private Admin name;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Categorie name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public Categorie detail(String detail) {
        this.detail = detail;
        return this;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Set<Firm> getFirms() {
        return firms;
    }

    public Categorie firms(Set<Firm> firms) {
        this.firms = firms;
        return this;
    }

    public Categorie addFirm(Firm firm) {
        this.firms.add(firm);
        firm.setName(this);
        return this;
    }

    public Categorie removeFirm(Firm firm) {
        this.firms.remove(firm);
        firm.setName(null);
        return this;
    }

    public void setFirms(Set<Firm> firms) {
        this.firms = firms;
    }

    public Admin getName() {
        return name;
    }

    public Categorie name(Admin admin) {
        this.name = admin;
        return this;
    }

    public void setName(Admin admin) {
        this.name = admin;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Categorie)) {
            return false;
        }
        return id != null && id.equals(((Categorie) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Categorie{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", detail='" + getDetail() + "'" +
            "}";
    }
}
