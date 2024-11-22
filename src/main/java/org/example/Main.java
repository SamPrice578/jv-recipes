package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Database.getSessionFactory();
        sessionFactory.getSchemaManager().exportMappedObjects(true);

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
	        tx = session.beginTransaction();
	        Category category = new Category(1, "Cake");
            session.merge(category);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) { //or tx != null, Chris isn't sure of best practice`
                tx.rollback();
            }
        } finally {
	        session.close();
        }

//        sessionFactory.inTransaction(session ->
//                session.persist(new Category(1, "Cake")));
    }
}