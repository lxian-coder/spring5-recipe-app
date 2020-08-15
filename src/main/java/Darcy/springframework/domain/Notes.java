package Darcy.springframework.domain;

import lombok.*;

import javax.persistence.*;

/**
 * spring5-recipe-app
 * Author: Darcy Xian  2020/8/512:55
 */
@Data
@EqualsAndHashCode(exclude = "recipe")
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

    public Notes() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Notes;
    }

}
