package com.teamtreehouse.instateam.dao;

import com.teamtreehouse.instateam.model.Collaborator;

import java.util.List;

public interface CollaboratorDao {
    Collaborator findById(int id);
    void saveCollaborator(Collaborator c);
    List<Collaborator> fetchAllCollaborators();
    void updateCollaborator(Collaborator c);
}
