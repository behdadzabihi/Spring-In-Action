package org.spring.in.action.spring.in.action.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.spring.in.action.spring.in.action.model.User;

import javax.persistence.*;
import java.util.Set;


@Data
public class RoleDTO {

    @ApiModelProperty(required = true,hidden = false)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private String name;

}
