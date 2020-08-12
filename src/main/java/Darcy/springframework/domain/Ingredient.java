package Darcy.springframework.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * spring5-recipe-app
 * Author: Darcy Xian  2020/8/515:15
 */

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmuont() {
        return amuont;
    }

    public void setAmuont(BigDecimal amuont) {
        this.amuont = amuont;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
    }
}
