package org.spring.in.action.spring.in.action.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.spring.in.action.spring.in.action.model.Ingredient;
import org.spring.in.action.spring.in.action.model.TacoIngredient;
import org.spring.in.action.spring.in.action.model.TacoOrder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class TacoDTO {

    @ApiModelProperty(required = true,hidden = false)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private String name;


}
