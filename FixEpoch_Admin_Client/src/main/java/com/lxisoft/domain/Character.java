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

    @Column(name = "firm_name")
    private String firmName;

    @Column(name = "ph_number")
    private String phNumber;

    @Column(name = "adress")
    private String adress;

    @Column(name = "email")
    private String email;

    @Column(name = "time")
    private String time;

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

    public Character firmName(String firmName) {
        this.firmName = firmName;
        return this;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public Character phNumber(String phNumber) {
        this.phNumber = phNumber;
        return this;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public String getAdress() {
        return adress;
    }

    public Character adress(String adress) {
        this.adress = adress;
        return this;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public Character email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTime() {
        return time;
    }

    public Character time(String time) {
        this.time = time;
        return this;
    }

    public void setTime(String time) {
        this.time = time;
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
            ", firmName='" + getFirmName() + "'" +
            ", phNumber='" + getPhNumber() + "'" +
            ", adress='" + getAdress() + "'" +
            ", email='" + getEmail() + "'" +
            ", time='" + getTime() + "'" +
            "}";
    }
}
