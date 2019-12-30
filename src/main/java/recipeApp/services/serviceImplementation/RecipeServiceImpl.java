package recipeApp.services.serviceImplementation;

import recipeApp.model.Recipe;
import recipeApp.repositories.RecipeRepository;
import recipeApp.services.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

// Author: Shifat63

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> findAll() throws Exception {
        log.info("start: findAll method of RecipeServiceImpl");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().forEach(recipeSet::add);
        log.info("end: findAll method of RecipeServiceImpl");
        return recipeSet;
    }

    @Override
    public Recipe findById(Long recipeId) throws Exception {
        log.info("start: findById method of RecipeServiceImpl");
        Recipe recipe = recipeRepository.findById(recipeId).get();
        log.info("end: findById method of RecipeServiceImpl");
        return recipe;
    }

    @Override
    public Recipe saveOrUpdate(Recipe recipe) throws Exception {
        log.info("start: saveOrUpdate method of RecipeServiceImpl");
        recipe = recipeRepository.save(recipe);
        log.info("end: saveOrUpdate method of RecipeServiceImpl");
        return recipe;
    }

    @Override
    public void deleteById(Long recipeId) throws Exception {
        log.info("start: deleteById method of RecipeServiceImpl");
        recipeRepository.deleteById(recipeId);
        log.info("end: deleteById method of RecipeServiceImpl");
    }
}
