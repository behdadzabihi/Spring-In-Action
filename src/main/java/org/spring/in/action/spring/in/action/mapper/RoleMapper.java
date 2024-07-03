package org.spring.in.action.spring.in.action.mapper;

import org.mapstruct.Mapper;
import org.spring.in.action.spring.in.action.dto.RoleDTO;
import org.spring.in.action.spring.in.action.dto.UserDTO;
import org.spring.in.action.spring.in.action.model.Role;
import org.spring.in.action.spring.in.action.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toRole(RoleDTO roleDTO);

    RoleDTO toRoleDTO(Role role);

    List<Role> toRoles(List<RoleDTO> roleDTOS);

    List<RoleDTO> toRoleDTOS(List<Role> roles);
}
