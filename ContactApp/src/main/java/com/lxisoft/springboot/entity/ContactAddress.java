package com.lxisoft.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name ="contact_address")
public class ContactAddress {
@Column(name = "house_details")
    private String houseNameAndPlace;
@Column(name = "post")
    private String post;
@Column(name = "district")
    private String district;
@Column(name="pincode")
    private String pinCode;
    @Id
    @Column(name="contact_id")
    private String contact_id;
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public String getHouseNameAndPlace() {
        return houseNameAndPlace;
    }

    public void setHouseNameAndPlace(String houseNameAndPlace) {
        this.houseNameAndPlace = houseNameAndPlace;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getContact_id() {
        return contact_id;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
