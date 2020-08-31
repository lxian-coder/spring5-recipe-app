package Darcy.springframework.converters;

import Darcy.springframework.commands.RecipeCommand;
import Darcy.springframework.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Darcy Xian  23/8/20  9:55 pm      spring5-recipe-app
 */
public class RecipeToRecipeCommandTest {
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

    public static final Difficulty DIFFICULTY = Difficulty.HARD;

    RecipeToRecipeCommand converter;

    @Before
    public void setUp() throws Exception {
        converter= new RecipeToRecipeCommand(new NotesToNotesCommand(),new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),new CategoryToCategoryCommand());
    }
    @Test
    public void testNullObject(){
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new Recipe()));
    }
    @Test
    public void convert() {
        //given
        Recipe recipe = new Recipe();
        recipe.setUrl(URL);
        recipe.setSource(SOURCE);
        recipe.setId(ID);
        recipe.setDirections(DIRECTIONS);
        recipe.setPrepTime(PREPTIME);
        recipe.setServings(SERVIINGS);
        recipe.setCookTime(COOKTIME);
        recipe.setDifficulty(DIFFICULTY);
        recipe.setDescription(DESCRIPTION);

        Notes notes = new Notes();
        notes.setId(NOTE_ID);
        recipe.setNotes(notes);

        Category category = new Category();
        category.setId(CT_ID1);
        Category category1 = new Category();
        category.setId(CT_ID2);
        recipe.getCategories().add(category);
        recipe.getCategories().add(category1);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(IG_ID1);
        Ingredient ingredient1 = new Ingredient();
        ingredient.setId(IG_ID2);
        recipe.getIngredients().add(ingredient);
        recipe.getIngredients().add(ingredient1);

        // when
        RecipeCommand recipeCommand = converter.convert(recipe);

        // then
        assertNotNull(recipeCommand);
        assertEquals(ID,recipeCommand.getId());
        assertEquals(DESCRIPTION,recipeCommand.getDescription());
        assertEquals(SOURCE,recipeCommand.getSource());
        assertEquals(DIRECTIONS,recipeCommand.getDirections());
        assertEquals(PREPTIME,recipeCommand.getPrepTime());
        assertEquals(SERVIINGS,recipeCommand.getServings());
        assertEquals(URL,recipeCommand.getUrl());
        assertEquals(DIFFICULTY,recipeCommand.getDifficulty());
        assertEquals(COOKTIME,recipeCommand.getCookTime());
        assertEquals(2,recipeCommand.getIngredients().size());
        assertEquals(2,recipeCommand.getCategories().size());
        assertEquals(NOTE_ID,recipeCommand.getNotes().getId());
        assertEquals(DIFFICULTY,recipeCommand.getDifficulty());
    }
}



























