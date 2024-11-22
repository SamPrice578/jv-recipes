package org.example;

import org.hibernate.SessionFactory;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Database.getSessionFactory();
        sessionFactory.getSchemaManager().exportMappedObjects(true);

//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//        try {
//	        tx = session.beginTransaction();
//	        Category category = new Category(1, "Cake");
//            session.merge(category);
//            Category cake = session.get(Category.class, 1);
//            System.out.println(cake.toString());
//            tx.commit();
//        } catch (Exception e) {
//            if(tx != null) { //or tx != null, Chris isn't sure of best practice`
//                tx.rollback();
//            }
//        } finally {
//	        session.close();
//        }

        sessionFactory.inTransaction(session ->
                session.persist(new Category(1, "Cake")));

        sessionFactory.inTransaction(session -> {
            Category cake = session.get(Category.class, 1);
            System.out.println(cake);
        });

        sessionFactory.inTransaction(session -> {
            session.persist(new Ingredient(1, "Butter", 200, "g"));
        });

        sessionFactory.inTransaction(session -> {
            Ingredient butter = session.get(Ingredient.class, 1);
            System.out.println(butter);
        });

        sessionFactory.inTransaction(session -> {
            session.persist(new RecipeUser(1, "Sam", "Sam@northcoders.com", "12345", UserRole.Admin, Date.valueOf("2024-01-01")));
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
            session.persist(new Recipe(1, "Chocolate Cake", "Tasty cake", "Mix ingredients and cook...", 15, 30, 5, 10, ingredients, categories, recipeUser, Date.valueOf("2024-01-01"), Date.valueOf("2024-02-01")));
        });

        sessionFactory.inTransaction(session -> {
            Recipe recipe = session.get(Recipe.class, 1);
            System.out.println(recipe);
        });






    }
}