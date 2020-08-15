package Darcy.springframework.servicesImpl;

import Darcy.springframework.domain.Recipe;
import Darcy.springframework.repositories.RecipeRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

import static org.mockito.Mockito.*;


/**
 * Darcy Xian  13/8/20  3:51 pm      spring5-recipe-app
 */
public class recipeServiceImplTest extends TestCase {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);

    }

    public void testGetRecipe() {

        Recipe recipe1 = new Recipe();
        HashSet<Recipe> recipeData = new HashSet<>();

        recipeData.add(recipe1);
        // 当有这个 findAll() 命令执行时候   return 括号中的object.
        when(recipeRepository.findAll()).thenReturn(recipeData);

        Iterable<Recipe>  recipes = recipeService.getRecipe();
       HashSet<Recipe> recipes2 = (HashSet<Recipe>)recipes;

        assertEquals(1, recipes2.size());

        // 想让findAll 执行几次， 如果次数不对，就显示出来！
        verify(recipeRepository,times(1)).findAll();



    }
}