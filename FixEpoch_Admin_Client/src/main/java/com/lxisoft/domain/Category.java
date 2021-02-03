package com.lxisoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Category.
 */
@Entity
@Table(name = "category")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "details")
    private String details;

    @OneToMany(mappedBy = "category")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Firm> firms = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "categories", allowSetters = true)
    private Admin admin;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Category categoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDetails() {
        return details;
    }

    public Category details(String details) {
        this.details = details;
        return this;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Set<Firm> getFirms() {
        return firms;
    }

    public Category firms(Set<Firm> firms) {
        this.firms = firms;
        return this;
    }

    public Category addFirm(Firm firm) {
        this.firms.add(firm);
        firm.setCategory(this);
        return this;
    }

    public Category removeFirm(Firm firm) {
        this.firms.remove(firm);
        firm.setCategory(null);
        return this;
    }

    public void setFirms(Set<Firm> firms) {
        this.firms = firms;
    }

    public Admin getAdmin() {
        return admin;
    }

    public Category admin(Admin admin) {
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
        if (!(o instanceof Category)) {
            return false;
        }
        return id != null && id.equals(((Category) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Category{" +
            "id=" + getId() +
            ", categoryName='" + getCategoryName() + "'" +
            ", details='" + getDetails() + "'" +
            "}";
    }
}
