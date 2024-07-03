package org.spring.in.action.spring.in.action.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserRoleDTO {

    @ApiModelProperty(required = true,hidden = false)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private UserDTO user;


    @ApiModelProperty(required = true,hidden = false)
    private RoleDTO role;

}
