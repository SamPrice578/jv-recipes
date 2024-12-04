package org.example;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // NOTE: 'value' is a reserved keyword in the H2 dialect
    @Min(1)
    @Max(5)
    @Column(name = "rating_value")
    private int value;

    @Column(name = "date_rated")
    private Date dateRated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "associated_recipe")
    private Recipe associatedRecipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rater_id")
    private RecipeUser rater;

    public Rating() {
    }

    public Rating(int value, Date dateRated, Recipe associatedRecipe, RecipeUser rater) {
        this.value = value;
        this.dateRated = dateRated;
        this.associatedRecipe = associatedRecipe;
        this.rater = rater;
    }

}
