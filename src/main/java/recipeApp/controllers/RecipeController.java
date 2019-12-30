package recipeApp.controllers;

import recipeApp.enums.Difficulty;
import recipeApp.model.Recipe;
import recipeApp.services.service.CategoryService;
import recipeApp.services.service.IngredientService;
import recipeApp.services.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

// Author: Shifat63

@Slf4j
@Controller
public class RecipeController {
    private final RecipeService recipeService;
    private final CategoryService categoryService;
    private final IngredientService ingredientService;

    public RecipeController(RecipeService recipeService, CategoryService categoryService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
        this.ingredientService = ingredientService;
    }

    @RequestMapping({"", "/", "/index", "/recipe", "/recipe/", "/recipe/index"})
    public String getIndexPage(Model model) throws Exception {
        log.info("start: getIndexPage method of RecipeController");
        model.addAttribute("recipes", recipeService.findAll());
        log.info("end: getIndexPage method of RecipeController");
        return "recipe/index";
    }

    @RequestMapping({"/recipe/add"})
    public String addRecipeGet(Model model) throws Exception {
        log.info("start: addRecipeGet method of RecipeController");
        model.addAttribute("recipe", new Recipe());
        List<Difficulty> difficultyEnums = Arrays.asList(Difficulty.values());
        model.addAttribute("difficultyEnums",difficultyEnums);
        model.addAttribute("ingredients",ingredientService.findAll());
        model.addAttribute("categories",categoryService.findAll());
        log.info("end: addRecipeGet method of RecipeController");
        return "recipe/add";
    }

    @RequestMapping(value = {"/recipe/add"}, method = RequestMethod.POST)
    public String addRecipePost(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult, Model model) throws Exception {
        log.info("start: addRecipePost method of RecipeController");
        if(bindingResult.hasErrors())
        {
            log.error("error: addRecipePost method of RecipeController -> Recipe model validation failed");
            List<Difficulty> difficultyEnums = Arrays.asList(Difficulty.values());
            model.addAttribute("difficultyEnums",difficultyEnums);
            model.addAttribute("ingredients",ingredientService.findAll());
            model.addAttribute("categories",categoryService.findAll());
            return "recipe/add";
        }
        Recipe savedRecipe = recipeService.saveOrUpdate(recipe);
        log.info("end: addRecipePost method of RecipeController");
        return "redirect:/recipe/view/"+savedRecipe.getRecipeId();
    }

    @RequestMapping({"/recipe/view/{recipeId}"})
    public String viewRecipe(@PathVariable("recipeId") Long recipeId, Model model) throws Exception {
        log.info("start: viewRecipe method of RecipeController");
        model.addAttribute("recipe", recipeService.findById(recipeId));
        log.info("end: viewRecipe method of RecipeController");
        return "recipe/view";
    }

    @RequestMapping({"/recipe/edit/{recipeId}"})
    public String editRecipe(@PathVariable("recipeId") Long recipeId, Model model) throws Exception {
        log.info("start: editRecipe method of RecipeController");
        model.addAttribute("recipe", recipeService.findById(recipeId));
        List<Difficulty> difficultyEnums = Arrays.asList(Difficulty.values());
        model.addAttribute("difficultyEnums",difficultyEnums);
        model.addAttribute("ingredients",ingredientService.findAll());
        model.addAttribute("categories",categoryService.findAll());
        log.info("end: editRecipe method of RecipeController");
        return "recipe/add";
    }

    @RequestMapping({"/recipe/delete/{recipeId}"})
    public String deleteRecipe(@PathVariable("recipeId") Long recipeId) throws Exception {
        log.info("start: deleteRecipe method of RecipeController");
        recipeService.deleteById(recipeId);
        log.info("end: deleteRecipe method of RecipeController");
        return "redirect:/recipe/index";
    }
}
