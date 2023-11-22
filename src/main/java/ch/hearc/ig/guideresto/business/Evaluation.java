package ch.hearc.ig.guideresto.business;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public abstract class Evaluation {
  @Id
  @GeneratedValue
  private Integer id;
  @Column(name = "DATE_EVAL")
  private LocalDate visitDate;
  private Restaurant restaurant;

  public Evaluation(Integer id, LocalDate visitDate, Restaurant restaurant) {
    this.id = id;
    this.visitDate = visitDate;
    this.restaurant = restaurant;
  }
}