package org.spring.in.action.spring.in.action.mapper;

import org.mapstruct.Mapper;
import org.spring.in.action.spring.in.action.dto.UserDTO;
import org.spring.in.action.spring.in.action.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    List<User> toUsers(List<UserDTO> userDTOS);

    List<UserDTO> toUserDTOs(List<User> users);
}
