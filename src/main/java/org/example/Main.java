package org.example;

import org.hibernate.SessionFactory;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Database.getSessionFactory();
        sessionFactory.getSchemaManager().exportMappedObjects(true);

        sessionFactory.inTransaction(session ->
                session.persist(new Category("Cake")));

        sessionFactory.inTransaction(session -> {
            Category cake = session.get(Category.class, 1);
            System.out.println(cake);
        });

        sessionFactory.inTransaction(session -> {
            session.persist(new Ingredient("Butter", 200, "g"));
        });

        sessionFactory.inTransaction(session -> {
            Ingredient butter = session.get(Ingredient.class, 1);
            System.out.println(butter);
        });

        sessionFactory.inTransaction(session -> {
            session.persist(new RecipeUser("Sam", "Sam@northcoders.com", "12345", UserRole.Admin, Date.valueOf("2024-01-01")));
        });

        sessionFactory.inTransaction(session -> {
            RecipeUser user = session.get(RecipeUser.class, 1);
            System.out.println(user);
        });

        sessionFactory.inTransaction(session -> {
            Ingredient butter = session.get(Ingredient.class, 1);
            Ingredient[] ingredients = {butter};
            Category category = session.get(Category.class, 1);
            Category[] categories = {category};
            RecipeUser recipeUser = session.get(RecipeUser.class, 1);
            session.persist(new Recipe("Chocolate Cake", "Tasty cake", "Mix ingredients and cook...", 15, 30, 1, 5, 10, ingredients, categories, recipeUser, Date.valueOf("2024-01-01"), Date.valueOf("2024-02-01")));
        });

        sessionFactory.inTransaction(session -> {
            Recipe recipe = session.get(Recipe.class, 1);
            System.out.println(recipe);
        });

        sessionFactory.inTransaction(session -> {
            Recipe recipe = session.get(Recipe.class, 1);
            RecipeUser recipeUser = session.get(RecipeUser.class, 1);
            session.persist(new Comment("This cake is great!", Date.valueOf("2024-02-03"), recipeUser, recipe));
        });

        sessionFactory.inTransaction(session -> {
            Comment comment = session.get(Comment.class, 1);
            System.out.println(comment);
        });

        sessionFactory.inTransaction((session -> {
            session.persist(new Tag("Chocolatey"));
        }));

        sessionFactory.inTransaction(session -> {
            Tag tag = session.get(Tag.class, 1);
            System.out.println(tag);
        });

        sessionFactory.inTransaction((session -> {
            String inputString = "cake pic";
            byte[] byteArray = inputString.getBytes();
            Recipe recipe = session.get(Recipe.class, 1);
            session.persist(new Image("cake_picture", byteArray, recipe));
        }));

        sessionFactory.inTransaction(session -> {
            Image image = session.get(Image.class, 1);
            System.out.println(image);
        });

        sessionFactory.inTransaction((session -> {
            Recipe recipe = session.get(Recipe.class, 1);
            RecipeUser recipeUser = session.get(RecipeUser.class, 1);
            session.persist(new Rating(5, Date.valueOf("2024-02-03"), recipe, recipeUser));
        }));

        sessionFactory.inTransaction(session -> {
            Image image = session.get(Image.class, 1);
            System.out.println(image);
        });

    }
}