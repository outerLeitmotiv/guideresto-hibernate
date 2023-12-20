package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.BasicEvaluation;
import ch.hearc.ig.guideresto.persistence.BasicEvaluationDAO;

public class BasicEvaluationService extends GenericService<BasicEvaluation, Integer> {

    private BasicEvaluationDAO basicEvaluationDAO;

    public BasicEvaluationService() {
        super(BasicEvaluation.class);
        this.basicEvaluationDAO = new BasicEvaluationDAO();
    }
}
