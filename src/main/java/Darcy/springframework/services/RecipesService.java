package Darcy.springframework.services;

import Darcy.springframework.commands.RecipeCommand;
import Darcy.springframework.domain.Recipe;



public interface RecipesService {
    Iterable<Recipe> getRecipe();
    Recipe getRecipeById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
    RecipeCommand findCommandById(Long l);

    void deleteById(Long id);


}




