package com.teamtreehouse.instateam.service;

import com.teamtreehouse.instateam.dao.RoleDao;
import com.teamtreehouse.instateam.model.Role;
import com.teamtreehouse.instateam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public List<Role> fetchAllRoles() {
        return roleDao.fetchAllRoles();
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public Role findById(int id) {
        return roleDao.findById(id);
    }
}
