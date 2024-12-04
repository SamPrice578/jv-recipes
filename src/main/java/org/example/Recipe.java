package org.example;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Arrays;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    private String instructions;

    private int preparationTime;

    private int cookingTime;

    private int servings;

    private int difficultyLevel;

    private int rating;

    @ManyToMany
    private Ingredient[] listOfIngredients;

    @ManyToMany
    private Category[] listOfCategories;

    @ManyToOne(fetch = FetchType.LAZY)
    private RecipeUser creator;

    private Date dateCreated;

    private Date lastModified;

    public Recipe(
            String title,
            String description,
            String instructions,
            int preparationTime,
            int cookingTime,
            int servings,
            int difficultyLevel,
            int rating,
            Ingredient[] listOfIngredients,
            Category[] listOfCategories,
            RecipeUser creator,
            Date dateCreated,
            Date lastModified) {

        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.servings = servings;
        this.difficultyLevel = difficultyLevel;
        this.rating = rating;
        this.listOfIngredients = listOfIngredients;
        this.listOfCategories = listOfCategories;
        this.creator = creator;
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
    }

    public Recipe() {
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", instructions='" + instructions + '\'' +
                ", preparationTime=" + preparationTime +
                ", cookingTime=" + cookingTime +
                ", servings=" + servings +
                ", difficultyLevel=" + difficultyLevel +
                ", rating=" + rating +
                ", listOfIngredients=" + Arrays.toString(listOfIngredients) +
                ", listOfCategories=" + Arrays.toString(listOfCategories) +
                ", creator=" + creator +
                ", dateCreated=" + dateCreated +
                ", lastModified=" + lastModified +
                '}';
    }
}
