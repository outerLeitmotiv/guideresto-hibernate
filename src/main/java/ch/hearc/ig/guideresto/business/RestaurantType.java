package ch.hearc.ig.guideresto.business;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "TYPES_RESTAURANTS")
public class RestaurantType {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "LIBELLE")
    private String label;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "type")
    private Set<Restaurant> restaurants;

    public RestaurantType(Integer id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.restaurants = new HashSet<>();
    }
    
    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }
}