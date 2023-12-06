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

  @ManyToOne
  @JoinColumn(name = "fk_rest")
  private Restaurant restaurant;

  protected Evaluation() {}

  protected Evaluation(Integer id, LocalDate visitDate, Restaurant restaurant) {
    this.id = id;
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

  public void setId(Integer id) {
    this.id = id;
  }

  public void setVisitDate(LocalDate visitDate) {
    this.visitDate = visitDate;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Evaluation)) return false;
    Evaluation that = (Evaluation) o;
    return id != null && id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
