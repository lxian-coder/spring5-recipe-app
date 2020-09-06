package Darcy.springframework.servicesImpl;

import Darcy.springframework.commands.IngredientCommand;
import Darcy.springframework.converters.IngredientCommandToIngredient;
import Darcy.springframework.converters.IngredientToIngredientCommand;
import Darcy.springframework.converters.UnitOfMeasureCommandToUnitOfMeasure;
import Darcy.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import Darcy.springframework.domain.Ingredient;
import Darcy.springframework.domain.Recipe;
import Darcy.springframework.repositories.RecipeRepository;
import Darcy.springframework.repositories.UnitOfMeasureRepository;
import Darcy.springframework.services.IngredientService;
import Darcy.springframework.services.RecipesService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Darcy Xian  1/9/20  7:39 pm      spring5-recipe-app
 */
public class IngredientImplTest  {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    RecipesService recipesService ;
    @Mock
    RecipeRepository recipeRepository;
    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;


    IngredientService ingredientService;

    //init converters

    public IngredientImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());

    }
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ingredientService = new IngredientImpl( ingredientToIngredientCommand,recipeRepository, unitOfMeasureRepository,ingredientCommandToIngredient);


    }
    @Test
    public void testFindByRecipeIdAndIngredientId() {
    }
    @Test
    public void findByRecipeIdAndIdHappyPath() throws Exception{
        // given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        // when
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L,3L);

        // then
        assertEquals(Long.valueOf(3L),ingredientCommand.getId());
        assertEquals(Long.valueOf(1L),ingredientCommand.getRecipeId());
        verify(recipeRepository,times(1)).findById(anyLong());

    }
    @Test
    public void testSaveRecipeCommand() throws Exception{
        //given
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(3L);
        ingredientCommand.setRecipeId(2L);

        Optional<Recipe> recipeOptional = Optional.of(new Recipe());

        Recipe saveRecipe = new Recipe();
        saveRecipe.addIngredient(new Ingredient());
        saveRecipe.getIngredients().iterator().next().setId(3L);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        when(recipeRepository.save(any(Recipe.class))).thenReturn(saveRecipe);

        // when
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(ingredientCommand);

        //then
        assertEquals(Long.valueOf(3L),savedCommand.getId());
        verify(recipeRepository,times(1)).findById(anyLong());
        verify(recipeRepository,times(1)).save(any(Recipe.class));

    }
   @Test
   public void testdeleteById() throws Exception{
        //given
       Recipe recipe = new Recipe();
       Ingredient ingredient = new Ingredient();
       ingredient.setId(3L);
       recipe.addIngredient(ingredient);
       ingredient.setRecipe(recipe);
       Optional<Recipe> recipeOptional = Optional.of(recipe);

       when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

       //when
       ingredientService.deleteIngredientById(1L,3L);

       //then
       verify(recipeRepository,times(1)).findById(anyLong());
       verify(recipeRepository,times(1)).save(any(Recipe.class));

   }
}



























































