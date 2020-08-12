package Darcy.springframework.servicesImpl;

import Darcy.springframework.domain.Recipe;
import Darcy.springframework.repositories.RecipeRepository;
import Darcy.springframework.services.RecipesService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class recipeServiceImpl implements RecipesService {

    private RecipeRepository  recipeRepository;
   // private Set<Recipe> recipes = new HashSet<>();

    public recipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Iterable<Recipe> getRecipe() {
        log.debug("I am in serviceImpl");
       return recipeRepository.findAll();

    }
}
