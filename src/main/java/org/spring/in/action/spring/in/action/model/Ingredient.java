package org.spring.in.action.spring.in.action.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spring.in.action.spring.in.action.model.enumtype.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_ingredient")
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Long id;

  @NotNull
  private  String name;

  @Enumerated(value = EnumType.STRING)
  @NotNull
  private  Type type;

  @OneToMany(fetch = FetchType.LAZY,mappedBy = "ingredient", cascade = CascadeType.ALL)
  private List<TacoIngredient> tacoIngredients;

}
