package ch.hearc.ig.guideresto.business;

import jakarta.persistence.*;

@Entity
@Table(name = "CRITERES_EVALUATION")
public class EvaluationCriteria {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "nom")
    private String name;
    @Column(name = "description")
    private String description;

    public EvaluationCriteria(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}