package com.lxisoft.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Address.
 */
@Entity
@Table(name = "address")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "country")
    private String country;

    @ManyToOne
    @ManyToOne
    @JsonIgnoreProperties(value = { "addresses", "addresses" }, allowSetters = true)
    private Contact contact;

    @ManyToOne
    @ManyToOne
    @JsonIgnoreProperties(value = { "addresses", "addresses" }, allowSetters = true)
    private Contact contact;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Address id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public Address placeName(String placeName) {
        this.setPlaceName(placeName);
        return this;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCountry() {
        return this.country;
    }

    public Address country(String country) {
        this.setCountry(country);
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address contact(Contact contact) {
        this.setContact(contact);
        return this;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address contact(Contact contact) {
        this.setContact(contact);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        return id != null && id.equals(((Address) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Address{" +
            "id=" + getId() +
            ", placeName='" + getPlaceName() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }
}
