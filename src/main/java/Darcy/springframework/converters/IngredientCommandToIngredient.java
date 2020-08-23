package Darcy.springframework.converters;

import Darcy.springframework.commands.IngredientCommand;
import Darcy.springframework.domain.Ingredient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Darcy Xian  22/8/20  10:05 pm      spring5-recipe-app
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source != null) {
            Ingredient ingredient = new Ingredient();
            ingredient.setUom(converter.convert(source.getUomC()));
            ingredient.setDescription(source.getDescription());
            ingredient.setAmuont(source.getAmount());
            ingredient.setId(source.getId());
           return ingredient;
        }
        return null;
    }
}
