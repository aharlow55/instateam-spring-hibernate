package com.teamtreehouse.instateam.service;

import com.teamtreehouse.instateam.dao.CollaboratorDao;
import com.teamtreehouse.instateam.model.Collaborator;
import com.teamtreehouse.instateam.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    @Autowired
    private CollaboratorDao collaboratorDao;


    @Override
    public Collaborator findById(int id) {
        return collaboratorDao.findById(id);
    }

    @Override
    public void saveCollaborator(Collaborator c) {
        collaboratorDao.saveCollaborator(c);
    }

    @Override
    public List<Collaborator> fetchAllCollaborators() {
        return collaboratorDao.fetchAllCollaborators();
    }

    @Override
    public void updateCollaborator(Collaborator c) {
        collaboratorDao.updateCollaborator(c);
    }
}
