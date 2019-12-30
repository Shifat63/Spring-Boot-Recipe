package recipeApp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import recipeApp.model.Category;
import recipeApp.services.service.CategoryService;
import javax.validation.Valid;

// Author: Shifat63

@Slf4j
@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping({"/category", "/category/", "/category/index"})
    public String getIndexPage(Model model) throws Exception {
        log.info("start: getIndexPage method of CategoryController");
        model.addAttribute("categories", categoryService.findAll());
        log.info("end: getIndexPage method of CategoryController");
        return "category/index";
    }

    @RequestMapping({"/category/add"})
    public String addCategoryGet(Model model) throws Exception {
        log.info("start: addCategoryGet method of CategoryController");
        model.addAttribute("category", new Category());
        log.info("end: addCategoryGet method of CategoryController");
        return "category/add";
    }

    @RequestMapping(value = {"/category/add"}, method = RequestMethod.POST)
    public String addCategoryPost(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) throws Exception {
        log.info("start: addCategoryPost method of CategoryController");
        if(bindingResult.hasErrors())
        {
            log.error("error: addCategoryPost method of CategoryController -> Category model validation failed");
            return "category/add";
        }
        categoryService.saveOrUpdate(category);
        log.info("end: addCategoryPost method of CategoryController");
        return "redirect:/category/index";
    }

    @RequestMapping({"/category/edit/{categoryId}"})
    public String editCategory(@PathVariable("categoryId") Long categoryId, Model model) throws Exception {
        log.info("start: editCategory method of CategoryController");
        model.addAttribute("category", categoryService.findById(categoryId));
        log.info("end: editCategory method of CategoryController");
        return "category/add";
    }

    @RequestMapping({"/category/delete/{categoryId}"})
    public String deleteCategory(@PathVariable("categoryId") Long categoryId) throws Exception {
        log.info("start: deleteCategory method of CategoryController");
        categoryService.deleteById(categoryId);
        log.info("end: deleteCategory method of CategoryController");
        return "redirect:/category/index";
    }
}
