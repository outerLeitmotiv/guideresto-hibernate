package ch.hearc.ig.guideresto.business;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "LIKES")
public class BasicEvaluation extends Evaluation {
  @Column(name = "APPRECIATION")
  private boolean likeRestaurant;

  @Column(name = "ADRESSE_IP")
  private String ipAddress;

  public BasicEvaluation(Integer id, LocalDate visitDate, Restaurant restaurant, boolean likeRestaurant,
      String ipAddress) {
    super(id, visitDate, restaurant);
    this.likeRestaurant = likeRestaurant;
    this.ipAddress = ipAddress;
  }

  public Boolean isLikeRestaurant() {
    return likeRestaurant;
  }

}