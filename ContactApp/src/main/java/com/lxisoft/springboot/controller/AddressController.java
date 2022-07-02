package com.lxisoft.springboot.controller;


import com.lxisoft.springboot.entity.Contact;
import com.lxisoft.springboot.entity.ContactAddress;
import com.lxisoft.springboot.service.ContactAddressService;
import com.lxisoft.springboot.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.util.Optional;

@Controller
public class AddressController {

    @Autowired
    ContactAddressService addressService;
    @Autowired
    private ContactService contactService;

    @GetMapping("/showAddressForm/{contact_id}")
    public String showForm(@PathVariable int contact_id,Model model) {
        // create model attribute to bind form data
        model.addAttribute("address", new ContactAddress(contact_id));
        model.addAttribute("caption", "ADD NEW ADDRESS");
        return "address";
    }
    @PostMapping("/saveAddress/contact/{contact_id}")
    public String saveContact(@PathVariable int contact_id,@ModelAttribute("contactAddress") ContactAddress contactAddress) {
        Contact contact = contactService.getContact(contact_id);
        contactAddress.setContact(contact);
        addressService.saveContactAddress(contactAddress);
        return "redirect:/contactAddress/" +contact_id;
    }
    @GetMapping("/deleteAddress/{addressId}/contact/{contact_id}")
    public String deleteContactAddress(@PathVariable(value = "addressId") int addressId,@PathVariable(value = "contact_id") int contact_id) {
        addressService.deleteContactAddress(addressId);;
        return "redirect:/contactAddress/" +contact_id;
    }

    @GetMapping("/showUpdateForm/{addressId}/contact/{contact_id}")
    public String showFormUpdate(@PathVariable(value = "addressId") int addressId, Model model,@PathVariable(value = "contact_id") int contact_id) {
        ContactAddress contactAddress = addressService.getContactAddress(addressId);
        model.addAttribute("contactAddress", contactAddress);
        model.addAttribute("caption", "UPDATE CONTACT");
        return "edit_address";
    }



}
