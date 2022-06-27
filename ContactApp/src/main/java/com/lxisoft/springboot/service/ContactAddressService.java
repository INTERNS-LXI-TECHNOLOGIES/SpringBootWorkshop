package com.lxisoft.springboot.service;

import com.lxisoft.springboot.entity.ContactAddress;

public interface ContactAddressService {
    void saveContactAddress(ContactAddress contactAddress);
    ContactAddress getContactAddress(Integer address_id);
    void deleteContactAddress(Integer address_id);
}
