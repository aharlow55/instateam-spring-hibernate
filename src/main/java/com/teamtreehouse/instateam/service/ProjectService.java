package com.teamtreehouse.instateam.service;

import com.teamtreehouse.instateam.model.Project;

import java.util.List;

public interface ProjectService {
    Project findById(int id);
    void saveProject(Project project);
    List<Project> fetchAllProjects();
    void updateProject(Project project);
    void deleteProject(Project project);
}
