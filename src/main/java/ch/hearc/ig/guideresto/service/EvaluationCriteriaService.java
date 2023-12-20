package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.EvaluationCriteria;
import ch.hearc.ig.guideresto.persistence.EvaluationCriteriaDAO;

public class EvaluationCriteriaService extends GenericService<EvaluationCriteria, Integer> {

    private EvaluationCriteriaDAO evaluationCriteriaDAO;

    public EvaluationCriteriaService() {
        super(EvaluationCriteria.class);
        this.evaluationCriteriaDAO = new EvaluationCriteriaDAO();
    }
}
