package org.spring.in.action.spring.in.action.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.spring.in.action.spring.in.action.model.Ingredient;
import org.spring.in.action.spring.in.action.model.Taco;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
public class TacoIngredientDTO {


    @ApiModelProperty(required = true,hidden = false)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private TacoDTO taco;


    @ApiModelProperty(required = true,hidden = false)
    private IngredientDTO ingredient;
}
