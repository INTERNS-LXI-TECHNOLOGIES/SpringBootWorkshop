package com.lxisoft.springboot.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Integer contact_id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "contact",cascade = { CascadeType.ALL } )
    private Set<ContactAddress> contactAddresses;


    @ManyToMany(mappedBy = "contacts")
    @OrderBy(value = "name")
    private Set<Project> projects = new HashSet<>();


    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<ContactAddress> getContactAddresses() {
        return contactAddresses;
    }

    public void setContactAddresses(Set<ContactAddress> contactAddresses) {
        this.contactAddresses = contactAddresses;
    }

    public Integer getContact_id() {
        return contact_id;
    }

    public void setContact_id(Integer contact_id) {
        this.contact_id = contact_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


