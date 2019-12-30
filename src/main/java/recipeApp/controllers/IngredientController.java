package recipeApp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import recipeApp.model.Ingredient;
import recipeApp.services.service.IngredientService;

import javax.validation.Valid;

// Author: Shifat63

@Slf4j
@Controller
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping({"/ingredient", "/ingredient/", "/ingredient/index"})
    public String getIndexPage(Model model) throws Exception {
        log.info("start: getIndexPage method of IngredientController");
        model.addAttribute("ingredients", ingredientService.findAll());
        log.info("end: getIndexPage method of IngredientController");
        return "ingredient/index";
    }

    @RequestMapping({"/ingredient/add"})
    public String addIngredientGet(Model model) throws Exception {
        log.info("start: addIngredientGet method of IngredientController");
        model.addAttribute("ingredient", new Ingredient());
        log.info("end: addIngredientGet method of IngredientController");
        return "ingredient/add";
    }

    @RequestMapping(value = {"/ingredient/add"}, method = RequestMethod.POST)
    public String addIngredientPost(@Valid @ModelAttribute("ingredient") Ingredient ingredient, BindingResult bindingResult, Model model) throws Exception {
        log.info("start: addIngredientPost method of IngredientController");
        if(bindingResult.hasErrors())
        {
            log.error("error: addIngredientPost method of IngredientController -> Ingredient model validation failed");
            return "ingredient/add";
        }
        ingredientService.saveOrUpdate(ingredient);
        log.info("end: addIngredientPost method of IngredientController");
        return "redirect:/ingredient/index";
    }

    @RequestMapping({"/ingredient/edit/{ingredientId}"})
    public String editIngredient(@PathVariable("ingredientId") Long ingredientId, Model model) throws Exception {
        log.info("start: editIngredient method of IngredientController");
        model.addAttribute("ingredient", ingredientService.findById(ingredientId));
        log.info("end: editIngredient method of IngredientController");
        return "ingredient/add";
    }

    @RequestMapping({"/ingredient/delete/{ingredientId}"})
    public String deleteIngredient(@PathVariable("ingredientId") Long ingredientId) throws Exception {
        log.info("start: deleteIngredient method of IngredientController");
        ingredientService.deleteById(ingredientId);
        log.info("end: deleteIngredient method of IngredientController");
        return "redirect:/ingredient/index";
    }
}
