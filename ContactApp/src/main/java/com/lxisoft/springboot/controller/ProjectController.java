package com.lxisoft.springboot.controller;

import com.lxisoft.springboot.entity.Project;
import com.lxisoft.springboot.service.ContactService;
import com.lxisoft.springboot.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectController {

    @Autowired
    ContactService contactService;

    @Autowired
    ProjectService projectService;

    @GetMapping("/project/{id}")
    public String viewProjects(@PathVariable Integer id, Model model) {
        Project project = projectService.getProject(id);
        model.addAttribute("project", project);
        return "projectDetails";
    }
    @GetMapping("/createProject")
    public String createProject(Model model) {
        model.addAttribute("project", new Project());
        return "addproject";
    }
    @PostMapping("/saveProject")
    public String saveOwner(@ModelAttribute Project project) {
        project = projectService.saveProject(project);
        return "redirect:/project/" + project.getId();
    }
}
