package Darcy.springframework.controllers;

import Darcy.springframework.commands.RecipeCommand;
import Darcy.springframework.domain.Recipe;
import Darcy.springframework.services.RecipesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Darcy Xian  21/8/20  9:17 am      spring5-recipe-app
 */
@Slf4j
@Controller
public class RecipeController {

   private final RecipesService recipesService;

    public RecipeController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }
    @GetMapping
    @RequestMapping({"/recipe/{id}/show"})
    public String displayRecipeById (@PathVariable Long id, Model model){

        Recipe recipe = recipesService.getRecipeById(id);
        model.addAttribute("recipeId",recipesService.getRecipeById(id));
        return "recipe/show";
    }
    @GetMapping
    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }
    @GetMapping
   @RequestMapping("recipe/{id}/update")
   public String updateRecipe(@PathVariable String id, Model model){
        // 从数据库里取出 recipe   然后转化为 RecipeCommand
        model.addAttribute("recipe",recipesService.findCommandById(Long.valueOf(id)));
      return "recipe/recipeform";
    }

   @PostMapping
   @RequestMapping("recipeee")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        // 实质是把recipe 转化为 recipecommand  然后存储起来  然后返回recipecommand
        RecipeCommand savedCommand = recipesService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show/";
    }
    @GetMapping
    @RequestMapping("/recipe/{id}/delete")
    public String deleteById(@PathVariable String id){
        log.debug("Deleting id: " + id);

        recipesService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
