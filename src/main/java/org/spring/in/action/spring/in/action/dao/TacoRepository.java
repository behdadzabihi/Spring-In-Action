package org.spring.in.action.spring.in.action.dao;

import org.spring.in.action.spring.in.action.model.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository 
         extends CrudRepository<Taco, Long> {

}
