package org.spring.in.action.spring.in.action.model;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_taco")
public class Taco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min=5, message="Name must be at least 5 characters long")
  private String name;

  @OneToMany
  @NotNull
  @Size(min=1, message="You must choose at least 1 ingredient")
  private List<Ingredient> ingredients;

  @OneToMany(fetch = FetchType.LAZY,mappedBy = "taco", cascade = CascadeType.ALL)
  private List<TacoOrder> tacoOrders;

  @OneToMany(fetch = FetchType.LAZY,mappedBy = "taco", cascade = CascadeType.ALL)
  private List<TacoIngredient> tacoIngredients;


}
