package Darcy.springframework.servicesImpl;

import Darcy.springframework.domain.Recipe;
import Darcy.springframework.repositories.RecipeRepository;
import Darcy.springframework.services.RecipesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
public class RecipeServiceImpl implements RecipesService {

    private RecipeRepository  recipeRepository;
   // private Set<Recipe> recipes = new HashSet<>();

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Iterable<Recipe> getRecipe() {
        log.debug("I am in serviceImpl");
       return recipeRepository.findAll();

    }

    @Override
    public Recipe getRecipeById(Long id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe Not Found");
        }
        return recipeOptional.get();
    }

}
