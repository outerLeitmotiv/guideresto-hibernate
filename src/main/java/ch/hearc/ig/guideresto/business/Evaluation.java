package ch.hearc.ig.guideresto.business;

import jakarta.persistence.*;

import java.time.LocalDate;
@MappedSuperclass
public abstract class Evaluation {
  @Id
  @GeneratedValue
  private Integer id;
  @Column(name = "DATE_EVAL")
  private LocalDate visitDate;
  @Column(name = "RESTAURANT")
  private Restaurant restaurant;

  public Evaluation(Integer id, LocalDate visitDate, Restaurant restaurant) {
    this.id = id;
    this.visitDate = visitDate;
    this.restaurant = restaurant;
  }
}