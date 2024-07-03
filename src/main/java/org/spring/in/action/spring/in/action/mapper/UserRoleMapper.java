package org.spring.in.action.spring.in.action.mapper;

import org.mapstruct.Mapper;
import org.spring.in.action.spring.in.action.dto.TacoDTO;
import org.spring.in.action.spring.in.action.dto.UserRoleDTO;
import org.spring.in.action.spring.in.action.model.Taco;
import org.spring.in.action.spring.in.action.model.UserRole;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    UserRole toUserRole(UserRoleDTO userRoleDTO);

    UserRoleDTO toUserRoleDTO(UserRole userRole);

    List<UserRole> toUserRoles(List<UserRoleDTO> userRoleDTOS);

    List<UserRoleDTO> toUserRoleDTOS(List<UserRole> userRoles);
}
