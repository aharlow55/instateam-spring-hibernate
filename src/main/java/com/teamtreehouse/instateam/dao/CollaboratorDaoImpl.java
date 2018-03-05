package com.teamtreehouse.instateam.dao;

import com.teamtreehouse.instateam.dao.CollaboratorDao;
import com.teamtreehouse.instateam.model.Collaborator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class CollaboratorDaoImpl implements CollaboratorDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Collaborator findById(int id) {
        Session session = sessionFactory.openSession();
        Collaborator collaborator = session.get(Collaborator.class, id);
        session.close();
        return collaborator;
    }

    @Override
    public void saveCollaborator(Collaborator c) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Collaborator> fetchAllCollaborators() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Collaborator> query = builder.createQuery(Collaborator.class);
        query.from(Collaborator.class);
        List<Collaborator> collaborators = session.createQuery(query).getResultList();
        session.close();
        return collaborators;
    }

    @Override
    public void updateCollaborator(Collaborator c) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
        session.close();
    }
}
