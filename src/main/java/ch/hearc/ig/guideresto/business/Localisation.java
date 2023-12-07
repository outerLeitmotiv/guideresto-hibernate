package ch.hearc.ig.guideresto.business;

import jakarta.persistence.*;

@Embeddable
public class Localisation {

    @Column(name = "ADRESSE", nullable = false)
    private String street;
    @ManyToOne
    @JoinColumn(name = "FK_VILL", nullable = false)
    private City city;

    public Localisation(String street, City city) {
        this.street = street;
        this.city = city;
    }

    public Localisation() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}