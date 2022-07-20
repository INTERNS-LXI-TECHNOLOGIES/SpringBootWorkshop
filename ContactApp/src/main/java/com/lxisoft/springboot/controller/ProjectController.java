package com.lxisoft.springboot.controller;

import com.lxisoft.springboot.entity.Contact;
import com.lxisoft.springboot.entity.Project;
import com.lxisoft.springboot.service.ContactService;
import com.lxisoft.springboot.service.ProjectService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    ContactService contactService;
    @Autowired
    ProjectService projectService;

    @GetMapping("/contact-project/{contactId}")
    public String viewProjects(@NotNull Model model, @PathVariable Integer contactId) {
        Contact contact = contactService.getContact(contactId);
//        Project project = projectService.getProject();
        model.addAttribute("contact", contact);
        model.addAttribute("contactId",contactId);
        return "projectDetails";
    }
    @GetMapping("/create-project/{contactId}")

    public String createProject(@PathVariable int contactId, Model model, @RequestParam(defaultValue = "") Integer projectId) {
        Contact contact = contactService.getContact(contactId);
        List<Project> projects = projectService.getProjects();
        projects.removeAll(contact.getProjects());
        Project project = null == projectId ? new Project() : projectService.getProject(projectId);
        contact.getProjects().add(project);
        model.addAttribute("contact", contact);
        model.addAttribute("project", project);
        model.addAttribute("contactId",contactId);
        model.addAttribute("projects", projects);
        return "addproject";
    }
    @PostMapping("contact/save-project/{contactId}")
    public String saveProject(@PathVariable int contactId,@ModelAttribute("Project") Project project) {
        Contact contact = contactService.getContact(contactId);
//        project = projectService.getProject(project.getProject_id());
        contact.getProjects().add(project);
//        project.getContacts().add(contact);
        contactService.saveContact(contact);
        return "redirect:/contact-project/" +contactId ;
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/editProject/{id}")
    public String editProject(@PathVariable Integer id, Model model) {
        Project project = projectService.getProject(id);
        model.addAttribute("project", project);
        return "editProject";
    }
    @PostMapping("/save-project")
    public String saveOwner(@ModelAttribute Project project) {
        project = projectService.saveProject(project);
        return "redirect:/home";
    }
        @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable("id") int id) {
        projectService.deleteProject(id);
        return "redirect:/home";
    }
    @GetMapping("/remove-contact/contactId/project/{id}")
    public String deleteContact(@PathVariable int contactId, @PathVariable Integer id) {
        Contact contact = contactService.getContact(contactId);
        Project project = projectService.getProject(id);
        contact.getProjects().remove(project);
        contactService.saveContact(contact);
        return "redirect:/contact-project/" + contactId;
    }
}
