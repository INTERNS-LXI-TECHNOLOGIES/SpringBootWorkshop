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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private Integer addressId;

    public ContactAddress() {
    }

    @Column(name="contact_id")
    private Integer contactId;
    @ManyToOne
    @JoinColumn(name = "contact_id" , referencedColumnName = "contact_id", insertable = false, updatable = false)
    private Contact contact;

    public ContactAddress(Integer contactId) {
        this.contactId = contactId;
    }

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


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
