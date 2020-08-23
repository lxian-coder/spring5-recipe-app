package Darcy.springframework.controllers;

import Darcy.springframework.services.RecipesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Darcy Xian  21/8/20  9:17 am      spring5-recipe-app
 */
@Controller
public class RecipeController {

   private final RecipesService recipesService;

    public RecipeController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @RequestMapping({"/recipe/show/{id}"})
    public String displayRecipeById (@PathVariable String id, Model model){

        model.addAttribute("recipeId",recipesService.getRecipeById(new Long(id)));
        return "recipe/show";
    }
}
