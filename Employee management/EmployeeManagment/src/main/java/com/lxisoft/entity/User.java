package com.lxisoft.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "user_Name")
    private String name;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "user_adress")
    private String adress;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "user_password")
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public User() {}

    public User(String name, String adress,String password) {
        this.name = name;
        this.adress=adress;
        this.password=password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}