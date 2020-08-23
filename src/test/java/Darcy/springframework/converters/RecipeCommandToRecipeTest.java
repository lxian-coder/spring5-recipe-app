package Darcy.springframework.converters;

import Darcy.springframework.commands.CategoryCommand;
import Darcy.springframework.commands.IngredientCommand;
import Darcy.springframework.commands.NotesCommand;
import Darcy.springframework.commands.RecipeCommand;
import Darcy.springframework.domain.Difficulty;
import Darcy.springframework.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Darcy Xian  23/8/20  11:16 pm      spring5-recipe-app
 */
public class RecipeCommandToRecipeTest {

    public static final Long ID = 1L;
    public static final String DESCRIPTION = "description";
    public static final Integer PREPTIME = 1;
    public static final Integer COOKTIME = 1;
    public static final Integer SERVIINGS =1;
    public static final String SOURCE = "source";
    public static final String URL ="WWW";
    public static final String DIRECTIONS = "directions";
    public static final Long NOTE_ID = 2L;
    public static final Long CT_ID1 = 1L;
    public static final Long CT_ID2 = 2L;
    public static final Long IG_ID1 = 1L;
    public static final Long IG_ID2 = 2L;
    RecipeCommandToRecipe converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeCommandToRecipe(new NotesCommandToNotes(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),new CategoryCommandToCategory());
    }
    @Test
    public void testNullObject(){
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new RecipeCommand()));
    }
    @Test
    public void convert() {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
       recipeCommand.setSource(SOURCE);
       recipeCommand.setUrl(URL);
       recipeCommand.setServings(SERVIINGS);
       recipeCommand.setPrepTime(PREPTIME);
       recipeCommand.setId(ID);
       recipeCommand.setDifficulty(Difficulty.EASY);
       recipeCommand.setPrepTime(PREPTIME);
       recipeCommand.setCookTime(COOKTIME);
       recipeCommand.setDirections(DIRECTIONS);
       recipeCommand.setDescription(DESCRIPTION);

       NotesCommand notesCommand = new NotesCommand();
       notesCommand.setId(NOTE_ID);
       recipeCommand.setNotes(notesCommand);

       IngredientCommand ingredientCommand = new IngredientCommand();
       ingredientCommand.setId(IG_ID1);
       IngredientCommand ingredientCommand1 = new IngredientCommand();
       ingredientCommand.setId(IG_ID2);
       recipeCommand.getIngredients().add(ingredientCommand);
       recipeCommand.getIngredients().add(ingredientCommand1);

        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(CT_ID1);
        CategoryCommand categoryCommand1 = new CategoryCommand();
        categoryCommand.setId(CT_ID2);
        recipeCommand.getCategories().add(categoryCommand);
        recipeCommand.getCategories().add(categoryCommand1);

        // when
        Recipe recipe = converter.convert(recipeCommand);
        // then
        assertNotNull(recipe);
        assertEquals(ID,recipe.getId());
        assertEquals(SOURCE,recipe.getSource());
        assertEquals(URL,recipe.getUrl());
        assertEquals(SERVIINGS,recipe.getServings());
        assertEquals(PREPTIME,recipe.getPrepTime());
        assertEquals(COOKTIME,recipe.getCookTime());
        assertEquals(DIRECTIONS,recipe.getDirections());
        assertEquals(DESCRIPTION,recipe.getDescription());
        assertEquals(Difficulty.EASY,recipe.getDifficulty());
        assertEquals(SOURCE,recipe.getSource());

        assertEquals(2,recipe.getCategories().size());
        assertEquals(2,recipe.getIngredients().size());
        assertEquals(NOTE_ID,recipe.getNotes().getId());

    }
}















