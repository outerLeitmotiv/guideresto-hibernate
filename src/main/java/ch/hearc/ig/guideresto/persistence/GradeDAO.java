package ch.hearc.ig.guideresto.persistence;

import ch.hearc.ig.guideresto.business.Grade;

public class GradeDAO extends GenericDAO<Grade, Integer> {
    public GradeDAO() {
        super(Grade.class);
    }
}
