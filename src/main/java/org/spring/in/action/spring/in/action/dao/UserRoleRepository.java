package org.spring.in.action.spring.in.action.dao;


import org.spring.in.action.spring.in.action.model.User;
import org.spring.in.action.spring.in.action.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

    UserRole findByUserIdAndRoleId(Long userId, Long roleId);
  
}
