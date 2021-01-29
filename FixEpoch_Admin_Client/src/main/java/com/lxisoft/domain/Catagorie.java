package com.lxisoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Catagorie.
 */
@Entity
@Table(name = "catagorie")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Catagorie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "catagorie_name")
    private String catagorieName;

    @Column(name = "details")
    private String details;

    @OneToMany(mappedBy = "catagorie")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Firm> firms = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "catagories", allowSetters = true)
    private Admin admin;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatagorieName() {
        return catagorieName;
    }

    public Catagorie catagorieName(String catagorieName) {
        this.catagorieName = catagorieName;
        return this;
    }

    public void setCatagorieName(String catagorieName) {
        this.catagorieName = catagorieName;
    }

    public String getDetails() {
        return details;
    }

    public Catagorie details(String details) {
        this.details = details;
        return this;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Set<Firm> getFirms() {
        return firms;
    }

    public Catagorie firms(Set<Firm> firms) {
        this.firms = firms;
        return this;
    }

    public Catagorie addFirm(Firm firm) {
        this.firms.add(firm);
        firm.setCatagorie(this);
        return this;
    }

    public Catagorie removeFirm(Firm firm) {
        this.firms.remove(firm);
        firm.setCatagorie(null);
        return this;
    }

    public void setFirms(Set<Firm> firms) {
        this.firms = firms;
    }

    public Admin getAdmin() {
        return admin;
    }

    public Catagorie admin(Admin admin) {
        this.admin = admin;
        return this;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Catagorie)) {
            return false;
        }
        return id != null && id.equals(((Catagorie) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Catagorie{" +
            "id=" + getId() +
            ", catagorieName='" + getCatagorieName() + "'" +
            ", details='" + getDetails() + "'" +
            "}";
    }
}
