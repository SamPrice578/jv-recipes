package org.example;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Arrays;

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

    @OneToMany
    Ingredient[] listOfIngredients; //

    @OneToMany
    Category[] listOfCategories; //many to many

    @ManyToOne(fetch = FetchType.LAZY)
    RecipeUser creator; //many to one - g.g one RecipeUser might make multiple reciepes.

    Date dateCreated;

    Date lastModified;

    public Recipe(int id, String title, String description, String instructions, int preparationTime, int cookingTime, int difficultyLevel, int rating, Ingredient[] listOfIngredients, Category[] listOfCategories, RecipeUser creator, Date dateCreated, Date lastModified) {
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
