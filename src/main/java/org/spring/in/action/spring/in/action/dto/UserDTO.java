package org.spring.in.action.spring.in.action.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
public class UserDTO  {



  @ApiModelProperty(required = true,hidden = false)
  private Long id;

  @ApiModelProperty(required = true,hidden = false)
  private final String username;

  @ApiModelProperty(required = true,hidden = false)
  private final String password;

  @ApiModelProperty(required = true,hidden = false)
  private final String fullname;

  @ApiModelProperty(required = true,hidden = false)
  private final String street;

  @ApiModelProperty(required = true,hidden = false)
  private final String city;

  @ApiModelProperty(required = true,hidden = false)
  private final String state;

  @ApiModelProperty(required = true,hidden = false)
  private final String zip;

  @ApiModelProperty(required = true,hidden = false)
  private final String phoneNumber;

}
