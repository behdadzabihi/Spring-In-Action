package org.spring.in.action.spring.in.action.mapper;

import org.mapstruct.Mapper;
import org.spring.in.action.spring.in.action.dto.TacoDTO;
import org.spring.in.action.spring.in.action.model.Taco;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TacoMapper {

    Taco totaco(TacoDTO tacoDTO);

    TacoDTO toTacoDTO(Taco taco);

    List<Taco> toTacos(List<TacoDTO> tacoDTOS);

    List<TacoDTO> toDacoDTOS(List<Taco> tacos);
}
