package Darcy.springframework.converters;

import Darcy.springframework.commands.IngredientCommand;
import Darcy.springframework.commands.UnitOfMeasureCommand;
import Darcy.springframework.domain.Ingredient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.Assert.*;


/**
 * Darcy Xian  22/8/20  11:12 pm      spring5-recipe-app
 */
public class IngredientCommandToIngredientTest {
    public static final Long ID = 1L;
    public static final String DESCRIPTION = "description";
    public static final BigDecimal AMOUNT = new BigDecimal(1);
    public static final Long UOMC_ID = 1L;
    public static  final Long RECIPE_ID = 4L;

    IngredientCommandToIngredient converter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }
  @Test
  public void testNullObject() {
        assertNull(converter.convert(null));
  }
  @Test
  public void testEmptyObject(){
        assertNotNull(converter.convert(new IngredientCommand()));
  }

    @Test
    public void convert() {
        //given
        UnitOfMeasureCommand  unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOMC_ID);

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setDescription(DESCRIPTION);
        ingredientCommand.setAmount(AMOUNT);
        ingredientCommand.setId(ID);
        ingredientCommand.setUomC(unitOfMeasureCommand);
        ingredientCommand.setRecipeId(RECIPE_ID);

        //When
       Ingredient ingredient =  converter.convert(ingredientCommand);

        //then
        assertNotNull(ingredient);
        assertEquals(DESCRIPTION,ingredient.getDescription());
        assertEquals(AMOUNT,ingredient.getAmount());
        assertEquals(ID,ingredient.getId());
        assertEquals(UOMC_ID,ingredient.getUom().getId());
        assertEquals(RECIPE_ID,ingredient.getRecipe().getId());

    }
}



















