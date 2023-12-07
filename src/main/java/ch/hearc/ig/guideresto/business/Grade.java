package ch.hearc.ig.guideresto.business;

import jakarta.persistence.*;

@Entity
@Table(name = "NOTES")
public class Grade {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SEQ_NOTES")
    @SequenceGenerator(name = "SEQ_NOTES", sequenceName = "SEQ_NOTES", initialValue = 1, allocationSize = 1)
    @Column(name = "NUMERO")
    private Integer id;

    @Column(name = "note")
    private Integer grade;

    @ManyToOne
    @JoinColumn(name = "fk_comm")
    private CompleteEvaluation evaluation;

    @ManyToOne
    @JoinColumn(name = "fk_crit")
    private EvaluationCriteria criteria;

    // Constructors
    public Grade() {}

    public Grade(Integer id, Integer grade, CompleteEvaluation evaluation, EvaluationCriteria criteria) {
        this.id = id;
        this.grade = grade;
        this.evaluation = evaluation;
        this.criteria = criteria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public CompleteEvaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(CompleteEvaluation evaluation) {
        this.evaluation = evaluation;
    }

    public EvaluationCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(EvaluationCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade)) return false;
        Grade grade = (Grade) o;
        return id != null && id.equals(grade.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
