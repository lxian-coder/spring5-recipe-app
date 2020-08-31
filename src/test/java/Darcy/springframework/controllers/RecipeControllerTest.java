package Darcy.springframework.controllers;

import Darcy.springframework.commands.RecipeCommand;
import Darcy.springframework.domain.Recipe;
import Darcy.springframework.services.RecipesService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

    }

    @Test
    public void displayRecipeById() throws Exception{

        Recipe recipe = new Recipe();
        recipe.setId(1L);
        when(recipesService.getRecipeById(anyLong())).thenReturn(recipe);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        mockMvc.perform(get("/recipe/1/show"))
                      .andExpect(status().isOk())
                      .andExpect(model().attributeExists("recipeId"))
                      .andExpect(view().name("recipe/show"));
    }
   @Test
    public void testPostNewRecipeForm() throws Exception {

       RecipeCommand command = new RecipeCommand();
       command.setId(2L);

       when(recipesService.saveRecipeCommand(any())).thenReturn(command);

       MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

       mockMvc.perform(post("/recipeee")
               .contentType(MediaType.APPLICATION_FORM_URLENCODED)
               .param("id","")
               .param("description","some string")
       )
                .andExpect(status().is3xxRedirection())
               .andExpect(view().name("redirect:/recipe/show/2"));
   }

   @Test
    public void testGetNewRecipeForm() throws Exception{
        RecipeCommand command = new RecipeCommand();

       MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

       mockMvc.perform(get("/recipe/new"))
               .andExpect(status().isOk())
               .andExpect(model().attributeExists("recipe"));
   }

@Test
    public void testGetupdateView() throws Exception{
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(2L);

        when(recipesService.findCommandById(anyLong())).thenReturn(recipeCommand);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        mockMvc.perform(get("/recipe/1/update"))
                        .andExpect(status().isOk())
                        .andExpect(view().name("recipe/recipeform"))
                        .andExpect(model().attributeExists("recipe"));
}







}



























