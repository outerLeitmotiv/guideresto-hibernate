package ch.hearc.ig.guideresto.business;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "VILLES")
public class City {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "CODE_POSTAL")
    private String zipCode;
    @Column(name = "NOM_VILLE")
    private String cityName;
    @OneToMany(mappedBy = "city")
    private Set<Restaurant> restaurants;

    public City(Integer id, String zipCode, String cityName) {
        this.id = id;
        this.zipCode = zipCode;
        this.cityName = cityName;
        this.restaurants = new HashSet<>();
    }
    
    public String getZipCode() {
        return zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }
}