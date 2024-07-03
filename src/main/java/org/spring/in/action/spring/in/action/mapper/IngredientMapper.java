package org.spring.in.action.spring.in.action.mapper;

import org.mapstruct.Mapper;
import org.spring.in.action.spring.in.action.dto.IngredientDTO;
import org.spring.in.action.spring.in.action.model.Ingredient;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    Ingredient toIngredient(IngredientDTO ingredientDTO);

    IngredientDTO toIngredientDTO(Ingredient ingredient);


    List<Ingredient> toIngredientList(List<IngredientDTO> ingredientDTOList);

    List<IngredientDTO> toIngredientDTOList(List<Ingredient> ingredientList);
}
