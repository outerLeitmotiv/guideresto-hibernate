package ch.hearc.ig.guideresto.persistence;

import ch.hearc.ig.guideresto.business.BasicEvaluation;
import jakarta.persistence.Query;
import org.hibernate.Session;

public class BasicEvaluationDAO extends GenericDAO<BasicEvaluation, Integer> {
    public BasicEvaluationDAO() {
        super(BasicEvaluation.class);
    }

}
