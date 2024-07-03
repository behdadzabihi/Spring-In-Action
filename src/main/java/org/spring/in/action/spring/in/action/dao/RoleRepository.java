package org.spring.in.action.spring.in.action.dao;


import org.spring.in.action.spring.in.action.model.Role;
import org.spring.in.action.spring.in.action.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
  
}
