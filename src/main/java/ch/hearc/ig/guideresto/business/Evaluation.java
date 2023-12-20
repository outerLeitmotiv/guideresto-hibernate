package ch.hearc.ig.guideresto.business;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;

@MappedSuperclass
@DiscriminatorColumn(name = "TYPE")
public abstract class Evaluation {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVAL")
  @SequenceGenerator(name = "SEQ_EVAL", sequenceName = "SEQ_EVAL", allocationSize = 1)
  @Column(name = "NUMERO")
  private Integer id;
  @Column(name = "DATE_EVAL")
  private LocalDate visitDate;

  @ManyToOne
  @JoinColumn(name = "fk_rest")
  private Restaurant restaurant;

  protected Evaluation() {}

  protected Evaluation(Integer id, LocalDate visitDate, Restaurant restaurant) {
    this.visitDate = visitDate;
    this.restaurant = restaurant;
  }

public Integer getId() {
    return id;
  }


  public LocalDate getVisitDate() {
    return visitDate;
  }

  public Restaurant getRestaurant() {
    return restaurant;
  }

  public void setVisitDate(LocalDate visitDate) {
    this.visitDate = visitDate;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }
}
