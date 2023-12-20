package ch.hearc.ig.guideresto.persistence;

import ch.hearc.ig.guideresto.business.City;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class CityDAO extends GenericDAO<City, Integer> {

    public CityDAO() {
        super(City.class);
    }

    // Method to find a city by its zip code
    public Optional<City> findCityByZipCode(String zipCode) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            TypedQuery<City> query = em.createQuery(
                    "SELECT c FROM City c WHERE c.zipCode = :zipCode", City.class);
            query.setParameter("zipCode", zipCode);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        } finally {
            JpaUtils.closeEntityManager();
        }
    }
}
