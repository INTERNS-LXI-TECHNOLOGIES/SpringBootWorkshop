package com.lxisoft.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Admin.
 */
@Entity
@Table(name = "admin")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "ph_number")
    private String phNumber;

    @OneToMany(mappedBy = "admin")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Catagorie> catagories = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public Admin adminName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmail() {
        return email;
    }

    public Admin email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public Admin password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public Admin phNumber(String phNumber) {
        this.phNumber = phNumber;
        return this;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public Set<Catagorie> getCatagories() {
        return catagories;
    }

    public Admin catagories(Set<Catagorie> catagories) {
        this.catagories = catagories;
        return this;
    }

    public Admin addCatagorie(Catagorie catagorie) {
        this.catagories.add(catagorie);
        catagorie.setAdmin(this);
        return this;
    }

    public Admin removeCatagorie(Catagorie catagorie) {
        this.catagories.remove(catagorie);
        catagorie.setAdmin(null);
        return this;
    }

    public void setCatagories(Set<Catagorie> catagories) {
        this.catagories = catagories;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Admin)) {
            return false;
        }
        return id != null && id.equals(((Admin) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Admin{" +
            "id=" + getId() +
            ", adminName='" + getAdminName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", phNumber='" + getPhNumber() + "'" +
            "}";
    }
}
