package com.teamtreehouse.instateam.dao;

import com.teamtreehouse.instateam.dao.ProjectDao;
import com.teamtreehouse.instateam.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Project findById(int id) {
        Session session = sessionFactory.openSession();
        Project project = session.get(Project.class, id);
        session.close();
        return project;
    }

    @Override
    public void saveProject(Project project) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(project);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Project> fetchAllProjects() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Project> query = builder.createQuery(Project.class);
        query.from(Project.class);
        List<Project> projects = session.createQuery(query).getResultList();
        session.close();
        return projects;
    }

    @Override
    public void updateProject(Project project) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(project);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void deleteProject(Project project) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(project);
        session.getTransaction().commit();
        session.close();
    }
}
