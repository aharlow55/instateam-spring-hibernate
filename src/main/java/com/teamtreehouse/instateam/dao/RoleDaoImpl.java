package com.teamtreehouse.instateam.dao;

import com.teamtreehouse.instateam.dao.RoleDao;
import com.teamtreehouse.instateam.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role findById(int id) {
        Session session = sessionFactory.openSession();
        Role role = session.get(Role.class, id);
        return role;
    }

    @Override
    public void saveRole(Role role) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(role);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Role> fetchAllRoles() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery(Role.class);
        query.from(Role.class);
        List<Role> Roles = session.createQuery(query).getResultList();
        session.close();
        return Roles;
    }

    @Override
    public void updateRole(Role role) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(role);
        session.getTransaction().commit();
        session.close();
    }
}
