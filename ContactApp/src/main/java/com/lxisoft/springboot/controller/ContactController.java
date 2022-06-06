package com.lxisoft.springboot.controller;

import com.lxisoft.springboot.entity.Contact;
import com.lxisoft.springboot.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("/")
    public String welcome(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model, @Param("keyword") String keyword) {
        List<Contact> contactList = contactService.listAllContacts(keyword);
        model.addAttribute("contactList", contactList);
        model.addAttribute("keyword", keyword); 
        return "home";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        // create model attribute to bind form data
        model.addAttribute("contact", new Contact());
        model.addAttribute("caption", "ADD NEW CONTACT");

        return "new_contact";
    }

    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute("contact") Contact contact) {

        contactService.saveContact(contact);
        return "redirect:/";
    }

    @GetMapping("/showFormUpdate/{contact_id}")
    public String showFormUpdate(@PathVariable(value = "contact_id") int contact_id, Model model) {
        Contact contact = contactService.getContact(contact_id);
        model.addAttribute("contact", contact);
        model.addAttribute("caption", "UPDATE CONTACT");
        return "new_contact";
    }

    @GetMapping("/deleteContact/{contact_id}")
    public String deleteContact(@PathVariable(value = "contact_id") int contact_id) {
        this.contactService.deleteContact(contact_id);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
