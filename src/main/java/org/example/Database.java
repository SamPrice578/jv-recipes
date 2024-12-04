package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

import static java.lang.Boolean.TRUE;
import static org.hibernate.cfg.JdbcSettings.*;

public class Database {
    public static SessionFactory getSessionFactory() {
        // TODO
        return new Configuration()
                .setProperty("hibernate.connection.driver_class", "org.h2.Driver") // <-- Specifying our H2 in-memory database
                .setProperty(JAKARTA_JDBC_URL, "jdbc:h2:mem:db1")   // <-- Supplying our database's connection string
                .setProperty(JAKARTA_JDBC_USER, "sa")   // <-- Using the default username...
                .setProperty(JAKARTA_JDBC_PASSWORD, "") // <-- ... and password
                .setProperty(SHOW_SQL, TRUE.toString()) // <-- SQL formatting configuration
                .setProperty(FORMAT_SQL, TRUE.toString())
                .setProperty(HIGHLIGHT_SQL, TRUE.toString())
                .setProperty("hibernate.hikari.maximumPoolSize", "20")
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Ingredient.class)
                .addAnnotatedClass(RecipeUser.class)
                .addAnnotatedClass(Recipe.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Tag.class)
                .addAnnotatedClass(Image.class)
                .addAnnotatedClass(Rating.class)
                .buildSessionFactory();
    }

    static void seed() {
        SessionFactory sessionFactory = getSessionFactory();
        sessionFactory.inTransaction(session -> {
            session.persist(new Category("Cake"));
            session.persist(new Category("Chocolate"));
            session.persist(new Category("Treat"));

            session.persist(new Ingredient("Butter", 200, "g"));
            session.persist(new Ingredient("Egg", 2, "eggs"));
            session.persist(new Ingredient("Sugar", 200, "g"));
            session.persist(new Ingredient("Chocolate", 100, "g"));
            session.persist(new Ingredient("Oats", 200, "g"));
            session.persist(new Ingredient("Flour", 200, "g"));

            session.persist(new RecipeUser("Sam", "Sam@northcoders.com", "12345", UserRole.Admin, Date.valueOf("2024-01-01")));
            session.persist(new RecipeUser("Amy", "Amy@northcoders.com", "56789", UserRole.Admin, Date.valueOf("2024-02-02")));

            Ingredient butter = session.get(Ingredient.class, 1);
            Ingredient egg = session.get(Ingredient.class, 2);
            Ingredient sugar = session.get(Ingredient.class, 3);
            Ingredient chocolate = session.get(Ingredient.class, 4);
            Ingredient oats = session.get(Ingredient.class, 5);
            Ingredient flour = session.get(Ingredient.class, 6);

            Ingredient[] cakeIngredients = {butter, egg, sugar, chocolate, flour};
            Ingredient[] flapjackIngredients = {butter, sugar, oats};

            Category cakeCategory = session.get(Category.class, 1);
            Category chocolateCategory = session.get(Category.class, 2);
            Category treatCategory = session.get(Category.class, 3);

            Category[] chocCakeCategories = {cakeCategory, chocolateCategory, treatCategory};
            Category[] flapjackCategories = {treatCategory};

            RecipeUser sam = session.get(RecipeUser.class, 1);
            RecipeUser amy = session.get(RecipeUser.class, 2);

            session.persist(new Recipe("Chocolate Cake", "Tasty cake", "Mix cake ingredients and cook...", 15, 30, 1, 5, 5, cakeIngredients, chocCakeCategories, sam, Date.valueOf("2024-01-01"), Date.valueOf("2024-02-01")));
            session.persist(new Recipe("Flapjack", "Tasty flapjack", "Mix flapjack ingredients and cook...", 10, 20, 2, 4, 5, flapjackIngredients, flapjackCategories, amy, Date.valueOf("2024-01-01"), Date.valueOf("2024-02-01")));

            Recipe cakeRecipe = session.get(Recipe.class, 1);

            session.persist(new Comment("This cake is great!", Date.valueOf("2024-02-03"), amy, cakeRecipe));

            session.persist(new Tag("Chocolatey"));

            String inputString = "cake pic";
            byte[] byteArray = inputString.getBytes();

            session.persist(new Image("cake_picture", byteArray, cakeRecipe));
        });
    }
}