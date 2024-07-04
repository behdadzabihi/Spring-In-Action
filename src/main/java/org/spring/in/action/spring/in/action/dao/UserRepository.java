package org.spring.in.action.spring.in.action.dao;


import org.spring.in.action.spring.in.action.model.User;
import org.spring.in.action.spring.in.action.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);

  
}
