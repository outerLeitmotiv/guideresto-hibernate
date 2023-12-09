package ch.hearc.ig.guideresto.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDAO<E, I extends Serializable> {

    private final Class<E> entityClass;
    protected final SessionFactory sessionFactory;

    protected GenericDAO(Class<E> entityClass) {
        this.entityClass = entityClass;
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void saveOrUpdate(E entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
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
            if (session != null) {
                session.close();
                System.out.println("Session closed");
            }
        }
    }


    public void update(E entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public E findById(I id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(entityClass, id);
        }
    }

    public List<E> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from " + entityClass.getName(), entityClass).list();
        }
    }

    public void delete(E entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
