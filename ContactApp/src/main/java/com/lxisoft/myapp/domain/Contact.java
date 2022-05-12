package com.lxisoft.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Contact.
 */
@Entity
@Table(name = "contact")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "contact")
    @OneToMany(mappedBy = "contact")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "contact", "contact" }, allowSetters = true)
    private Set<Address> addresses = new HashSet<>();

    @OneToMany(mappedBy = "contact")
    @OneToMany(mappedBy = "contact")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "contact", "contact" }, allowSetters = true)
    private Set<Address> addresses = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Contact id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactName() {
        return this.contactName;
    }

    public Contact contactName(String contactName) {
        this.setContactName(contactName);
        return this;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public Contact contactNumber(String contactNumber) {
        this.setContactNumber(contactNumber);
        return this;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public Contact email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        if (this.addresses != null) {
            this.addresses.forEach(i -> i.setContact(null));
        }
        if (addresses != null) {
            addresses.forEach(i -> i.setContact(this));
        }
        this.addresses = addresses;
    }

    public Contact addresses(Set<Address> addresses) {
        this.setAddresses(addresses);
        return this;
    }

    public Contact addAddress(Address address) {
        this.addresses.add(address);
        address.setContact(this);
        return this;
    }

    public Contact removeAddress(Address address) {
        this.addresses.remove(address);
        address.setContact(null);
        return this;
    }

    public Set<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        if (this.addresses != null) {
            this.addresses.forEach(i -> i.setContact(null));
        }
        if (addresses != null) {
            addresses.forEach(i -> i.setContact(this));
        }
        this.addresses = addresses;
    }

    public Contact addresses(Set<Address> addresses) {
        this.setAddresses(addresses);
        return this;
    }

    public Contact addAddress(Address address) {
        this.addresses.add(address);
        address.setContact(this);
        return this;
    }

    public Contact removeAddress(Address address) {
        this.addresses.remove(address);
        address.setContact(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contact)) {
            return false;
        }
        return id != null && id.equals(((Contact) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Contact{" +
            "id=" + getId() +
            ", contactName='" + getContactName() + "'" +
            ", contactNumber='" + getContactNumber() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
}
