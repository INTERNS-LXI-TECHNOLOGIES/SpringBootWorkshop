package com.lxisoft.springboot.service;

import com.lxisoft.springboot.entity.Project;

import java.util.List;

public interface ProjectService {

    Project saveProject(Project project);

    Project getProject(Integer projectId);

    void deleteProject(Integer projectId);

    List<Project> getProjects();
}
