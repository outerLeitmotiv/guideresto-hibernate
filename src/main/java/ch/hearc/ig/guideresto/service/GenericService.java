package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.persistence.JpaUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class GenericService<E, I extends Serializable> {

    private final Class<E> entityClass;

    protected GenericService(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public void saveOrUpdate(E entity) {
        JpaUtils.executeInTransaction(em -> em.merge(entity));
    }

    public Optional<E> findById(I id) {
        return JpaUtils.executeInTransaction(em -> Optional.ofNullable(em.find(entityClass, id)));
    }

    public List<E> findAll() {
        return JpaUtils.executeInTransaction(em -> em.createQuery("from " + entityClass.getName(), entityClass).getResultList());
    }

    public void delete(E entity) {
        JpaUtils.executeInTransaction(em -> {
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            return null;
        });
    }
}
