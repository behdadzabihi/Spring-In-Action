package org.spring.in.action.spring.in.action.dao;


import org.spring.in.action.spring.in.action.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);
  
}
