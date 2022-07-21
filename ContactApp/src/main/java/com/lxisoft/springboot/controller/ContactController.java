package com.lxisoft.springboot.controller;

import com.lxisoft.springboot.entity.Contact;
import com.lxisoft.springboot.entity.Project;
import com.lxisoft.springboot.service.ContactService;
import com.lxisoft.springboot.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {
    @Autowired
    ContactService contactService;

    @Autowired
    ProjectService projectService;

    @GetMapping("/")
    public String welcome(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model, @RequestParam(defaultValue = "1") Integer pageNo ) {
        contactService.listAllContacts(pageNo, model);
        return "home";
    }

    @GetMapping("/search")
    public String home(Model model, @RequestParam(defaultValue = "1") Integer pageNo ,@RequestParam(defaultValue = "") String keyword) {
        contactService.searchContacts(pageNo, keyword, model);
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

    @GetMapping("/showFormUpdate/{contactId}")
    public String showFormUpdate(@PathVariable(value = "contactId") int contactId, Model model) {
        Contact contact = contactService.getContact(contactId);
        model.addAttribute("contact", contact);
        model.addAttribute("caption", "UPDATE CONTACT");
        return "new_contact";
    }

    @GetMapping("/deleteContact/{contactId}")
    public String deleteContact(@PathVariable(value = "contactId") int contactId) {
        this.contactService.deleteContact(contactId);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/contact-address/{contactId}")
    public String contactAddressAndProject(@PathVariable int contactId, Model model) {
        Contact contact = contactService.getContact(contactId);
        model.addAttribute("contact", contact);
  /*      Project project = projectService.getProject(contact_id);
        model.addAttribute("project", project);*/
        Logger logger = LoggerFactory.getLogger(ContactController.class);
        logger.error("contact Address is : ",contact.getContactAddresses());

        return "contactAddress";
    }
}
