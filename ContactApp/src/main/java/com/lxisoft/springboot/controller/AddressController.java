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

    @GetMapping("/showAddressForm/{contactId}")
    public String showForm(@PathVariable int contactId,Model model) {
        // create model attribute to bind form data
        model.addAttribute("address", new ContactAddress(contactId));
        model.addAttribute("caption", "ADD NEW ADDRESS");
        return "address";
    }
    @PostMapping("/saveAddress/contact/{contactId}")
    public String saveContact(@PathVariable int contactId,@ModelAttribute("contactAddress") ContactAddress contactAddress) {
        Contact contact = contactService.getContact(contactId);
        contactAddress.setContact(contact);
        addressService.saveContactAddress(contactAddress);
        return "redirect:/contact-address/" +contactId;
    }
    @GetMapping("/deleteAddress/{addressId}/contact/{contactId}")
    public String deleteContactAddress(@PathVariable(value = "addressId") int addressId,@PathVariable(value = "contactId") int contactId) {
        addressService.deleteContactAddress(addressId);;
        return "redirect:/contact-address/" +contactId;
    }

    @GetMapping("/showUpdateForm/{addressId}/contact/{contactId}")
    public String showFormUpdate(@PathVariable(value = "addressId") int addressId, Model model,@PathVariable(value = "contactId") int contactId) {
        ContactAddress contactAddress = addressService.getContactAddress(addressId);
        model.addAttribute("contactAddress", contactAddress);
        model.addAttribute("caption", "UPDATE CONTACT");
        return "edit_address";
    }



}
