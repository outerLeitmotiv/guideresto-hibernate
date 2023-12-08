package ch.hearc.ig.guideresto.persistence;

import ch.hearc.ig.guideresto.business.Grade;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.Set;

public class GradeDAO extends GenericDAO<Grade, Integer> {
    public GradeDAO() {
        super(Grade.class);
    }

    public Set<Grade> findByEvaluation(Integer evaluationId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Grade> query = ((Session) session).createQuery(
                    "SELECT g FROM Grade g WHERE g.evaluation.id = :evaluationId");
            query.setParameter("evaluationId", evaluationId);
            return new HashSet<>(query.list());
        }
    }
}
