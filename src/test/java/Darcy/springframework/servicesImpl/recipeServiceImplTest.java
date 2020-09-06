package Darcy.springframework.servicesImpl;

import Darcy.springframework.converters.RecipeCommandToRecipe;
import Darcy.springframework.converters.RecipeToRecipeCommand;
import Darcy.springframework.domain.Recipe;
import Darcy.springframework.repositories.RecipeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


/**
 * Darcy Xian  13/8/20  3:51 pm      spring5-recipe-app
 */
public class recipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
    Long id = 1L;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository,recipeToRecipeCommand,recipeCommandToRecipe);

    }
    @Test
    public void testGetRecipeById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.getRecipeById(id);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository,never()).findAll();
    }

    @Test
    public void testGetRecipe() {

        Recipe recipe1 = new Recipe();
        HashSet<Recipe> recipeData = new HashSet<>();

        recipeData.add(recipe1);
        // 当有这个 findAll() 命令执行时候   return 括号中的object.
        when(recipeRepository.findAll()).thenReturn(recipeData);

        Iterable<Recipe>  recipes = recipeService.getRecipe();
        HashSet<Recipe> recipes2 = (HashSet<Recipe>)recipes;

        Assert.assertEquals(1, recipes2.size());

        // 想让findAll 执行几次， 如果次数不对，就显示出来！
        verify(recipeRepository,times(1)).findAll();

    }

   @Test
   public void testDeleteById() throws Exception{
        //given
        Long idToDelete = Long.valueOf(2L);

        //when
        recipeService.deleteById(idToDelete);
        // no 'when' since method has void return type
       //then
       verify(recipeRepository,times(1))
               .deleteById(anyLong());

   }







}





























