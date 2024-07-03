package org.spring.in.action.spring.in.action.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.spring.in.action.spring.in.action.model.Taco;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class TacoOrderDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String deliveryName;

    @ApiModelProperty(required = true,hidden = false)
    private String deliveryStreet;

    @ApiModelProperty(required = true,hidden = false)
    private String deliveryCity;

    @ApiModelProperty(required = true,hidden = false)
    private String deliveryState;

    @ApiModelProperty(required = true,hidden = false)
    private String deliveryZip;

    @ApiModelProperty(required = true,hidden = false)
    private String ccNumber;

    @ApiModelProperty(required = true,hidden = false)
    private String ccExpiration;

    @ApiModelProperty(required = true,hidden = false)
    private String ccCVV;

    @ApiModelProperty(required = true,hidden = false)
    private TacoDTO taco;
}
