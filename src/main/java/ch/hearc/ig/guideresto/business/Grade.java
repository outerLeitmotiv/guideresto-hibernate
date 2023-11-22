package ch.hearc.ig.guideresto.business;

import jakarta.persistence.*;

@Entity
@Table(name = "NOTES")
public class Grade {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "NOTE")
    private Integer grade;
    private CompleteEvaluation evaluation;
    private EvaluationCriteria criteria;

    public Grade(Integer id, Integer grade, CompleteEvaluation evaluation, EvaluationCriteria criteria) {
        this.id = id;
        this.grade = grade;
        this.evaluation = evaluation;
        this.criteria = criteria;
    }

    public Integer getGrade() {
        return grade;
    }

    public EvaluationCriteria getCriteria() {
        return criteria;
    }
}