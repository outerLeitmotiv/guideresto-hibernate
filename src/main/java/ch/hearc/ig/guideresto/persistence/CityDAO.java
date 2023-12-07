package ch.hearc.ig.guideresto.persistence;

import ch.hearc.ig.guideresto.business.City;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class CityDAO extends GenericDAO<City, Integer> {

    public CityDAO() {
        super(City.class);
    }

    // Method to find a city by its zip code
    public Optional<City> findCityByZipCode(String zipCode) {
        try (Session session = sessionFactory.openSession()) {
            Query<City> query = session.createQuery(
                    "SELECT c FROM City c WHERE c.zipCode = :zipCode", City.class);
            query.setParameter("zipCode", zipCode);
            return Optional.ofNullable(query.uniqueResult());
        }
    }

    // Method to find a city by its name
    public List<City> findCitiesByName(String partialName) {
        try (Session session = sessionFactory.openSession()) {
            Query<City> query = session.createQuery(
                    "SELECT c FROM City c WHERE lower(c.cityName) LIKE :partialName", City.class);
            query.setParameter("partialName", "%" + partialName.toLowerCase() + "%");
            return query.list();
        }
    }
}
