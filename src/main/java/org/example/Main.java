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

        //should fail
        sessionFactory.inTransaction(session -> {
            session.persist(new RecipeUser(2, "Sam", "Samnorthcoders.com", "12345", UserRole.Admin, Date.valueOf("2024-01-01")));
        });

        sessionFactory.inTransaction(session -> {
            RecipeUser user = session.get(RecipeUser.class, 2);
            System.out.println(user);
        });







    }
}