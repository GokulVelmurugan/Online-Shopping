package com.ideas2it.onlinestore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.onlinestore.model.Role;
import com.ideas2it.onlinestore.repository.RoleRepository;
import com.ideas2it.onlinestore.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    public boolean updateRole(Role role) {
        boolean isUpdated = false;
        role = roleRepository.save(role);

        if (null != role) {
            return true;
        }
        return false;
    }
}
