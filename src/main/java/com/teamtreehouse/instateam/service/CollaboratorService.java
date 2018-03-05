package com.teamtreehouse.instateam.service;

import com.teamtreehouse.instateam.model.Collaborator;

import java.util.List;

public interface CollaboratorService {
    Collaborator findById(int id);
    void saveCollaborator(Collaborator c);
    List<Collaborator> fetchAllCollaborators();
    void updateCollaborator(Collaborator c);
}
