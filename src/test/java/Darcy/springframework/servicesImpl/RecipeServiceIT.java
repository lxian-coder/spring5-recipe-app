package Darcy.springframework.servicesImpl;

import Darcy.springframework.commands.RecipeCommand;
import Darcy.springframework.converters.RecipeCommandToRecipe;
import Darcy.springframework.converters.RecipeToRecipeCommand;
import Darcy.springframework.domain.Recipe;
import Darcy.springframework.repositories.RecipeRepository;
import Darcy.springframework.services.RecipesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Darcy Xian  30/8/20  12:01 am      spring5-recipe-app
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT  {
    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    RecipesService recipesService;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;


    @Transactional
    @Test
    public void testSaveRecipeCommand() throws Exception {
    // given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();

        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        // when
        testRecipeCommand.setDescription(NEW_DESCRIPTION);
        RecipeCommand savedRecipeCommand = recipesService.saveRecipeCommand(testRecipeCommand);

        // then
        assertEquals(NEW_DESCRIPTION,savedRecipeCommand.getDescription());
        assertEquals(testRecipe.getId(),savedRecipeCommand.getId());
        assertEquals(testRecipe.getCategories().size(),savedRecipeCommand.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());


    }
}