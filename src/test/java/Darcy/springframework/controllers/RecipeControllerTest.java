package Darcy.springframework.controllers;

import Darcy.springframework.domain.Recipe;
import Darcy.springframework.services.RecipesService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Darcy Xian  21/8/20  9:48 am      spring5-recipe-app
 */
public class RecipeControllerTest {

    @Mock
    RecipesService recipesService;

    RecipeController recipeController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController(recipesService);
    }

    @Test
    public void displayRecipeById() throws Exception{

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        when(recipesService.getRecipeById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/show/1"))
                      .andExpect(status().isOk())
                      .andExpect(model().attributeExists("recipeId"))
                      .andExpect(view().name("recipe/show"));

    }
}



























