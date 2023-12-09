package ch.hearc.ig.guideresto.business;

import ch.hearc.ig.guideresto.persistence.BooleanConverter;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "LIKES")
public class BasicEvaluation extends Evaluation {

  @Convert(converter = BooleanConverter.class)
  @Column(name = "APPRECIATION")
  private boolean likeRestaurant;

  @Column(name = "ADRESSE_IP")
  private String ipAddress;

  public BasicEvaluation() {}

  public BasicEvaluation(Integer id, LocalDate visitDate, Restaurant restaurant, boolean likeRestaurant, String ipAddress) {
    super(id, visitDate, restaurant);
    this.likeRestaurant = likeRestaurant;
    this.ipAddress = ipAddress;
  }

  public boolean isLikeRestaurant() {
    return likeRestaurant;
  }

  public void setLikeRestaurant(boolean likeRestaurant) {
    this.likeRestaurant = likeRestaurant;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BasicEvaluation)) return false;
    if (!super.equals(o)) return false;
    BasicEvaluation that = (BasicEvaluation) o;
    return likeRestaurant == that.likeRestaurant && ipAddress.equals(that.ipAddress);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
