package ch.hearc.ig.guideresto.business;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMMENTAIRES")
public class CompleteEvaluation extends Evaluation {
  @Column(name = "COMMENTAIRE")
  private String comment;
  @Column(name = "UTILISATEUR")
  private String username;
  private Set<Grade> grades;

  public CompleteEvaluation(Integer id, LocalDate visitDate, Restaurant restaurant, String comment,
      String username) {
    super(id, visitDate, restaurant);
    this.comment = comment;
    this.username = username;
    this.grades = new HashSet<>();
  }

  public String getComment() {
    return comment;
  }

  public String getUsername() {
    return username;
  }

  public Set<Grade> getGrades() {
    return grades;
  }
}