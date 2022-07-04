package com.lxisoft.springboot.service;

import com.lxisoft.springboot.entity.Contact;
import com.lxisoft.springboot.entity.Project;
import com.lxisoft.springboot.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepo;
    @Override
    public Project saveProject(Project project) {
        if (project.getId() != null) {
            Project projectObj = getProject(project.getId());
            project.setContacts(projectObj.getContacts());
        }
        return projectRepo.save(project);
    }

    @Override
    public Project getProject(Integer id) {
        Optional<Project> optional = projectRepo.findById(id);
        Project project = null;
        if (optional.isPresent()) {
            project = optional.get();
        } else {
            throw new RuntimeException(" Project not found for id :: " + id);
        }
        return project;

    }

    @Override
    public void deleteProject(Integer id) {
        Project project = getProject(id);
        project.getContacts().clear();
        projectRepo.save(project);
        projectRepo.deleteById(id);
    }

    @Override
    public List<Project> getProjects() {

        return projectRepo.findAll();

    }
}
