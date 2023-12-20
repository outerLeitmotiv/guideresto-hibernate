package ch.hearc.ig.guideresto.persistence;

import jakarta.persistence.FlushModeType;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;


import java.util.function.Consumer;
import java.util.function.Function;



public class JpaUtils {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    private static final ThreadLocal<EntityManager> threadEM = new ThreadLocal<>();

    public static EntityManager getEntityManager() {
        EntityManager em = threadEM.get();
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
            em.setFlushMode(FlushModeType.COMMIT);
            threadEM.set(em);
        }
        return threadEM.get();
    }

    public static void closeEntityManager() {
        EntityManager em = threadEM.get();
        if (em != null && em.isOpen()) {
            em.close();
            threadEM.remove();
        }
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    public static void inTransaction(Consumer<EntityManager> action) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            action.accept(em);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public static <R> R executeInTransaction(Function<EntityManager, R> function) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            R result = function.apply(em);
            tx.commit();
            return result;
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
