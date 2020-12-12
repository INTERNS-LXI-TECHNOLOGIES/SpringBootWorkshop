package com.lxisoft.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "ownerName")
    private String ownerName;


    @Column(name = "adress")
    private String adress;

    @Column(name = "phno")
    private String phno;

    @Column(name = "booking")
    private Boolean booking;

     public Room() {}

    public Room(String ownerName, String adress,String phno) {
        this.ownerName = ownerName;
        this.adress = adress;
        this.phno = phno;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public Boolean getBooking() {
        return booking;
    }

    public void setBooking(Boolean booking) {
        this.booking = booking;
    }
}