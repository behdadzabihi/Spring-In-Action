package org.spring.in.action.spring.in.action.mapper;

import org.mapstruct.Mapper;
import org.spring.in.action.spring.in.action.dto.TacoOrderDTO;
import org.spring.in.action.spring.in.action.model.TacoOrder;

import java.util.List;

@Mapper(componentModel = "spring",uses = {TacoMapper.class})
public interface TacoOrderMapper {

    TacoOrder toTacoOrder(TacoOrderDTO tacoOrderDTO);

    TacoOrderDTO toTacoOrderDTO(TacoOrder tacoOrder);

    List<TacoOrder> toTacoOrders(List<TacoOrderDTO> tacoOrderDTOS);

    List<TacoOrderDTO> toTacoOrderDTOS(List<TacoOrder> tacoOrders);
}
