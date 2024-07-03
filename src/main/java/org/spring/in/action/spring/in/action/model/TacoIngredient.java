package org.spring.in.action.spring.in.action.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "tbl_taco_ingredient")
public class TacoIngredient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "taco_id")
    private Taco  taco;



    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
}
