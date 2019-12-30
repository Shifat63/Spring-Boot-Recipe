package recipeApp.model;

import recipeApp.enums.Difficulty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//Author: Shifat63

@Data
@Entity
@EqualsAndHashCode(exclude = {"ingredients", "categories"})
@ToString(exclude = {"ingredients", "categories"})
@Table(name = "recipe")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long recipeId;

    @NotBlank(message = "Name must not be empty")
    @Size(min = 1,max = 200, message = "Name must be between 1 to 200 characters")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Preparation time must not be empty")
    @Positive(message = "Preparation time must be positive")
    @Digits(integer = 3, fraction = 2, message = "Preparation time can have maximum 3 integer and 2 fraction digits")
    @Column(name = "preparation_time")
    private Float preparationTime;

    @NotNull(message = "Cook time must not be empty")
    @Positive(message = "Cook time must be positive")
    @Digits(integer = 3, fraction = 2, message = "Cook time can have maximum 3 integer and 2 fraction digits")
    @Column(name = "cook_time")
    private Float cookTime;

    @URL(message = "Insert a valid URL")
    @Column(name = "url")
    private String url;

    @Lob
    @NotBlank(message = "Description must not be empty")
    @Size(min = 1,max = 2000, message = "Description must be between 1 to 2000 characters")
    @Column(name = "description")
    private String description;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "Difficulty must not be empty")
    @Column(name = "difficulty")
    private Difficulty difficulty;

    @NotEmpty(message = "Recipe must have ingredients")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_ingredient", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id") )
    private Set<Ingredient> ingredients = new HashSet<>();

    @NotEmpty(message = "Recipe must belong to one or more than one category")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

}
