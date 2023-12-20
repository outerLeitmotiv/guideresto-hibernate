package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.CompleteEvaluation;
import ch.hearc.ig.guideresto.persistence.CompleteEvaluationDAO;

public class CompleteEvaluationService extends GenericService<CompleteEvaluation, Integer> {

    private CompleteEvaluationDAO completeEvaluationDAO;

    public CompleteEvaluationService() {
        super(CompleteEvaluation.class);
        this.completeEvaluationDAO = new CompleteEvaluationDAO();
    }
}
