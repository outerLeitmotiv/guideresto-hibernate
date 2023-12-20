package ch.hearc.ig.guideresto.persistence;

import jakarta.persistence.EntityTransaction;
import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.List;

public abstract class GenericDAO<E, I extends Serializable> {

    private final Class<E> entityClass;

    protected GenericDAO(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public void saveOrUpdate(E entity) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                try {
                    transaction.rollback();
                    System.out.println("Transaction rolled back");
                } catch (Exception ex) {
                    System.out.println("Error during transaction rollback: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
            System.out.println("Error in saveOrUpdate: " + e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            JpaUtils.closeEntityManager();
            System.out.println("Session closed");
        }
    }

    public E findById(I id) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            JpaUtils.closeEntityManager();
        }
    }

    public List<E> findAll() {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            return em.createQuery("from " + entityClass.getName(), entityClass).getResultList();
        } finally {
            JpaUtils.closeEntityManager();
        }
    }

    public void delete(E entity) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            JpaUtils.closeEntityManager();
        }
    }
}