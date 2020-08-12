package Darcy.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * spring5-recipe-app
 * Author: Darcy Xian  2020/8/610:49
 */
//@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

  @ManyToMany(mappedBy = "categories")
   private Set<Recipe> recipe;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipe = recipe;
    }
}
