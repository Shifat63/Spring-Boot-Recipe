package recipeApp.repositories;

import recipeApp.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// Author: Shifat63

@Repository
@Transactional
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
