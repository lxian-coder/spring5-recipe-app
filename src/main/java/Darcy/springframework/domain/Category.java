package Darcy.springframework.domain;

import lombok.*;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * spring5-recipe-app
 * Author: Darcy Xian  2020/8/610:49
 */
//@Data
@Data
@EqualsAndHashCode(exclude = "recipe")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

  @ManyToMany(mappedBy = "categories")
   private Set<Recipe> recipe = new HashSet<>();

}
