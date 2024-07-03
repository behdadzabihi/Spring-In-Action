package org.spring.in.action.spring.in.action.service.impl;

import lombok.AllArgsConstructor;
import org.spring.in.action.spring.in.action.dao.UserRoleRepository;
import org.spring.in.action.spring.in.action.model.Role;
import org.spring.in.action.spring.in.action.model.User;
import org.spring.in.action.spring.in.action.model.UserRole;
import org.spring.in.action.spring.in.action.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserRoleServiceImpl implements BaseService<UserRole> {

    private UserRoleRepository userRoleRepository;

    private UserServiceImpl userService;

    private RoleServiceImpl roleService;
    @Override
    public UserRole save(UserRole userRole) {
        Long roleId=userRole.getRole().getId();
        Role role=roleService.findById(roleId);
        userRole.setRole(role);

        Long userId=userRole.getUser().getId();
        User user=userService.findById(userId);
        userRole.setUser(user);
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole update(UserRole userRole) {
        return null;
    }

    @Override
    public UserRole findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<UserRole> findAll() {
        return null;
    }


}
