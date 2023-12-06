package ch.hearc.ig.guideresto.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ch.hearc.ig.guideresto.business.*;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Restaurant.class);
            configuration.addAnnotatedClass(RestaurantType.class);
            configuration.addAnnotatedClass(Grade.class);
            configuration.addAnnotatedClass(EvaluationCriteria.class);
            configuration.addAnnotatedClass(City.class);
            configuration.addAnnotatedClass(CompleteEvaluation.class);
            configuration.addAnnotatedClass(BasicEvaluation.class);

            return configuration.buildSessionFactory();
        } catch (Exception ex) {
            throw new ExceptionInInitializerError("Failed to create session factory: " + ex.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
