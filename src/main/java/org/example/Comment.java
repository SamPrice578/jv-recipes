package org.example;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    private Date datePosted;

    @ManyToOne
    private RecipeUser author;

    @ManyToOne
    private Recipe recipe;

    public Comment(String text, Date datePosted, RecipeUser author, Recipe recipe) {
        this.text = text;
        this.datePosted = datePosted;
        this.author = author;
        this.recipe = recipe;
    }

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", datePosted=" + datePosted +
                ", author=" + author +
                ", recipe=" + recipe +
                '}';
    }
}
