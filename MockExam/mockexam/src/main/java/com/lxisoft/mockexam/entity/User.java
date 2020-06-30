package com.lxisoft.mockexam.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn (name = "user_id")},
            inverseJoinColumns = {@JoinColumn (name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    //    @ManyToMany
    //    private Set<Role> roles;



    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
