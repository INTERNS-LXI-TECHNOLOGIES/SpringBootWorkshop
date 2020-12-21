package com.lxisoft.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id")
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "store_Name")
    private String name;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "store_adress")
    private String adress;

    @OneToMany(mappedBy = "name",cascade = CascadeType.ALL)
    private List<User> users;

    public Store() {}

    public Store(String name, String adress) {
        this.name = name;
        this.adress=adress;

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
}