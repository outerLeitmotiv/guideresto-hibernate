package ch.hearc.ig.guideresto.persistence;

import ch.hearc.ig.guideresto.business.Grade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.HashSet;
import java.util.Set;

public class GradeDAO extends GenericDAO<Grade, Integer> {
    public GradeDAO() {
        super(Grade.class);
    }

    public Set<Grade> findByEvaluation(Integer evaluationId) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            TypedQuery<Grade> query = em.createQuery(
                    "SELECT g FROM Grade g WHERE g.evaluation.id = :evaluationId", Grade.class);
            query.setParameter("evaluationId", evaluationId);
            return new HashSet<>(query.getResultList());
        } finally {
            JpaUtils.closeEntityManager();
        }
    }
}
