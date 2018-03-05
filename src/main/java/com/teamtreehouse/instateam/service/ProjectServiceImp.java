package com.teamtreehouse.instateam.service;

import com.teamtreehouse.instateam.dao.ProjectDao;
import com.teamtreehouse.instateam.model.Project;
import com.teamtreehouse.instateam.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectDao projectDao;


    @Override
    public Project findById(int id) {
        return projectDao.findById(id);
    }

    @Override
    public void saveProject(Project project) {
        projectDao.saveProject(project);
    }

    @Override
    public List<Project> fetchAllProjects() {
        return projectDao.fetchAllProjects();
    }

    @Override
    public void updateProject(Project project) {
        projectDao.updateProject(project);
    }

    @Override
    public void deleteProject(Project project) {
        projectDao.deleteProject(project);
    }
}
