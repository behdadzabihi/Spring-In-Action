package org.spring.in.action.spring.in.action.dao;

import org.spring.in.action.spring.in.action.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository 
         extends CrudRepository<Ingredient, String> {

}
