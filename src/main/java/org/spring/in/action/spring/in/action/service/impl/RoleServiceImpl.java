package org.spring.in.action.spring.in.action.service.impl;

import lombok.AllArgsConstructor;
import org.spring.in.action.spring.in.action.dao.RoleRepository;
import org.spring.in.action.spring.in.action.model.Role;
import org.spring.in.action.spring.in.action.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements BaseService<Role> {

    private RoleRepository  roleRepository;
    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public Role findById(Long id) {
        Optional<Role> optionalRole=roleRepository.findById(id);
        if(!optionalRole.isPresent()){
            throw new RuntimeException("Role not found with id " + id);
        }
        return optionalRole.get();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }
}
