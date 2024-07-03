package org.spring.in.action.spring.in.action.mapper;

import org.mapstruct.Mapper;
import org.spring.in.action.spring.in.action.dto.TacoIngredientDTO;
import org.spring.in.action.spring.in.action.model.TacoIngredient;

import java.util.List;

@Mapper(componentModel = "spring",uses = {TacoMapper.class,IngredientMapper.class})
public interface TacoIngredientMapper {

    TacoIngredient toTacoIngredient(TacoIngredientDTO  tacoIngredientDTO);

    TacoIngredientDTO toTacoIngredient(TacoIngredient tacoIngredient);

    List<TacoIngredient> toTacoIngredients(List<TacoIngredientDTO> tacoIngredientDTOS);
    List<TacoIngredientDTO> toTacoIngredientDTOS(List<TacoIngredient> TacoIngredient);
}
