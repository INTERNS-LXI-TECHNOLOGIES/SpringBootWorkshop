package com.lxisoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

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

    @NotNull
    @Column(name = "firm_name", nullable = false)
    private String firmName;

    @NotNull
    @Column(name = "ph_number", nullable = false)
    private String phNumber;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "adress", nullable = false)
    private String adress;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JsonIgnoreProperties(value = "firms", allowSetters = true)
    private Categorie name;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirmName() {
        return firmName;
    }

    public Firm firmName(String firmName) {
        this.firmName = firmName;
        return this;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
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

    public String getEmail() {
        return email;
    }

    public Firm email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public Firm adress(String adress) {
        this.adress = adress;
        return this;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStatus() {
        return status;
    }

    public Firm status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Categorie getName() {
        return name;
    }

    public Firm name(Categorie categorie) {
        this.name = categorie;
        return this;
    }

    public void setName(Categorie categorie) {
        this.name = categorie;
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
            ", firmName='" + getFirmName() + "'" +
            ", phNumber='" + getPhNumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", adress='" + getAdress() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
