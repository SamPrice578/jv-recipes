package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
                .buildSessionFactory();
    }
}