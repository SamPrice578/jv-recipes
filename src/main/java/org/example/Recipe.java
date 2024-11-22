package org.example;

import jakarta.persistence.*;

@Entity
public class Recipe {

    @Id
    int id;

    String title;

    String description;

    String instructions;

    int preparationTime;

    int cookingTime;

    int difficultyLevel;

    int rating;

    //annotation here?
    Ingredient[] listOfIngredients; //

    Category[] listOfCategories; //many to many

    @ManyToOne(fetch = FetchType.LAZY)
    RecipeUser creator; //many to one - g.g one RecipeUser might make multiple reciepes.


    public Recipe(int id, String title, String description, String instructions, int preparationTime, int cookingTime, int difficultyLevel, int rating, Ingredient[] listOfIngredients, Category[] listOfCategories, RecipeUser creator) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.difficultyLevel = difficultyLevel;
        this.rating = rating;
        this.listOfIngredients = listOfIngredients;
        this.listOfCategories = listOfCategories;
        this.creator = creator;
    }

    public Recipe() {
    }
}
