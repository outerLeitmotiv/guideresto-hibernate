package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.Grade;
import ch.hearc.ig.guideresto.persistence.GradeDAO;

import java.util.Set;

public class GradeService extends GenericService<Grade, Integer> {

    private GradeDAO gradeDAO;

    public GradeService() {
        super(Grade.class);
        this.gradeDAO = new GradeDAO();
    }

    public Set<Grade> findByEvaluation(Integer id) {
        return gradeDAO.findByEvaluation(id);
    }
}
