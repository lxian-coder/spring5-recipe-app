package Darcy.springframework.converters;

import Darcy.springframework.commands.RecipeCommand;
import Darcy.springframework.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Darcy Xian  23/8/20  9:29 pm      spring5-recipe-app
 */

@NoArgsConstructor
@AllArgsConstructor
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {
    private NotesToNotesCommand notesToNotesCommand;
    private IngredientToIngredientCommand ingredientToIngredientCommand;
    private CategoryToCategoryCommand categoryToCategoryCommand;
    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if(source != null){
            RecipeCommand recipeCommand = new RecipeCommand();
            recipeCommand.setCookTime(source.getCookTime());
            recipeCommand.setDescription(source.getDescription());
            recipeCommand.setDirections(source.getDirections());
            recipeCommand.setId(source.getId());
            recipeCommand.setPrepTime(source.getPrepTime());
            recipeCommand.setDifficulty(source.getDifficulty());
            recipeCommand.setSource(source.getSource());
            recipeCommand.setUrl(source.getUrl());
            recipeCommand.setServings(source.getServings());

            recipeCommand.setNotes(notesToNotesCommand.convert(source.getNotes()));

            if(source.getCategories() != null && source.getCategories().size()>0){
                source.getCategories().forEach(
                        category -> recipeCommand.getCategories().add(categoryToCategoryCommand.convert(category)));
            }
            if(source.getIngredients() != null && source.getIngredients().size()>0){
                source.getIngredients().forEach(
                        ingredient -> recipeCommand.getIngredients().add(ingredientToIngredientCommand.convert(ingredient)));
            }
            return recipeCommand;

        }
        return null;
    }
}
























