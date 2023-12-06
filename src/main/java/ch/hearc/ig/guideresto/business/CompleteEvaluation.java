package ch.hearc.ig.guideresto.business;

import jakarta.persistence.*;

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

  @OneToMany(mappedBy = "evaluation", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Grade> grades = new HashSet<>();

  public CompleteEvaluation() {}

  public CompleteEvaluation(Integer id, LocalDate visitDate, Restaurant restaurant, String comment, String username) {
    super(id, visitDate, restaurant);
    this.comment = comment;
    this.username = username;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Set<Grade> getGrades() {
    return grades;
  }

  public void setGrades(Set<Grade> grades) {
    this.grades = grades;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CompleteEvaluation)) return false;
    if (!super.equals(o)) return false;
    CompleteEvaluation that = (CompleteEvaluation) o;
    return comment.equals(that.comment) && username.equals(that.username) && grades.equals(that.grades);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
