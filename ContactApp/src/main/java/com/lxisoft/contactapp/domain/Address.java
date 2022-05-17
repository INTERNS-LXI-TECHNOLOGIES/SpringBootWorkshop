package com.lxisoft.contactapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Address.
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany(mappedBy = "address")
    @JsonIgnoreProperties(value = { "address" }, allowSetters = true)
    private Set<Contact> contacts = new HashSet<>();

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

    public String getCountryName() {
        return this.countryName;
    }

    public Address countryName(String countryName) {
        this.setCountryName(countryName);
        return this;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Set<Contact> getContacts() {
        return this.contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        if (this.contacts != null) {
            this.contacts.forEach(i -> i.setAddress(null));
        }
        if (contacts != null) {
            contacts.forEach(i -> i.setAddress(this));
        }
        this.contacts = contacts;
    }

    public Address contacts(Set<Contact> contacts) {
        this.setContacts(contacts);
        return this;
    }

    public Address addContact(Contact contact) {
        this.contacts.add(contact);
        contact.setAddress(this);
        return this;
    }

    public Address removeContact(Contact contact) {
        this.contacts.remove(contact);
        contact.setAddress(null);
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
            ", countryName='" + getCountryName() + "'" +
            "}";
    }
}
