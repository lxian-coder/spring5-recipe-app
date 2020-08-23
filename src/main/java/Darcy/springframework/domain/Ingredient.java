package Darcy.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * spring5-recipe-app
 * Author: Darcy Xian  2020/8/515:15
 */

@Data
@EqualsAndHashCode(exclude = "recipe")
@Entity
//@Table(name = "Ingerdients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "descriptionsss")
    private String description;
    private BigDecimal amuont;


    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure  uom;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amuont, UnitOfMeasure uom) {
        this.description = description;
        this.amuont = amuont;
        this.uom = uom;
    }
}
