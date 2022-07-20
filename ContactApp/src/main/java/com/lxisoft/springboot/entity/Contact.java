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
    private Integer contactId;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "contact",cascade = { CascadeType.ALL } )
    private Set<ContactAddress> contactAddresses;


    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @OrderBy(value = "name")
    @JoinTable(
            name = "contact_projects",
            joinColumns = {
                    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
            }
    )
    private Set<Project> projects = new HashSet<Project>();


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

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
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


