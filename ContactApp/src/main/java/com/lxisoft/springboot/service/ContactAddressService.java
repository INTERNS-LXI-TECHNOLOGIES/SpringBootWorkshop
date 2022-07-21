package com.lxisoft.springboot.service;

import com.lxisoft.springboot.entity.ContactAddress;

public interface ContactAddressService {
    void saveContactAddress(ContactAddress contactAddress);
    ContactAddress getContactAddress(Integer addressId);
    void deleteContactAddress(Integer addressId);
}
