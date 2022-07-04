package com.lxisoft.springboot.controller;

import com.lxisoft.springboot.entity.Project;
import com.lxisoft.springboot.service.ContactService;
import com.lxisoft.springboot.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}
