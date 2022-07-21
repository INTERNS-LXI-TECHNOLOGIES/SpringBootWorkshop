package com.lxisoft.springboot.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "name")
    private String projectName;

    @Column(name = "status")
    private Boolean projectStatus = false;

    @Column(name = "timescale")
    private String timeScale;

    @ManyToMany(mappedBy = "projects",cascade = {CascadeType.ALL})
//    @JsonIgnore
    private Set<Contact> contacts = new HashSet<Contact>();

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public void setProjectStatus(Boolean projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public boolean getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(boolean projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getTimeScale() {
        return timeScale;
    }

    public void setTimeScale(String timeScale) {
        this.timeScale = timeScale;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectStatus=" + projectStatus +
                ", timeScale='" + timeScale + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
