package org.spring.in.action.spring.in.action.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.spring.in.action.spring.in.action.model.TacoIngredient;
import org.spring.in.action.spring.in.action.model.enumtype.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class IngredientDTO {

    @ApiModelProperty(required = true,hidden = false)
    private final String id;

    @ApiModelProperty(required = true,hidden = false)
    private final String name;

    @ApiModelProperty(required = true,hidden = false)
    private final Type type;

}
