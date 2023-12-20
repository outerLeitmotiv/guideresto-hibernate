package ch.hearc.ig.guideresto.persistence;

import ch.hearc.ig.guideresto.business.Restaurant;
import ch.hearc.ig.guideresto.business.RestaurantType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RestaurantDAO extends GenericDAO<Restaurant, Integer> {

    public RestaurantDAO() {
        super(Restaurant.class);
    }

    // Method to find restaurants by name
    public List<Restaurant> findRestaurantByName(String name) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            TypedQuery<Restaurant> query = em.createQuery(
                    "SELECT r FROM Restaurant r WHERE lower(r.name) LIKE :name", Restaurant.class);
            query.setParameter("name", "%" + name.toLowerCase() + "%");
            return query.getResultList();
        } finally {
            JpaUtils.closeEntityManager();
        }
    }

    // Method to find restaurants by city
    public List<Restaurant> findRestaurantsByCityName(String partialCityName) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            String queryStr = "SELECT r FROM Restaurant r WHERE lower(r.address.city.cityName) LIKE :partialCityName";
            TypedQuery<Restaurant> query = em.createQuery(queryStr, Restaurant.class);
            query.setParameter("partialCityName", "%" + partialCityName.toLowerCase() + "%");
            return query.getResultList();
        } finally {
            JpaUtils.closeEntityManager();
        }
    }

    // Method to find restaurants by type
    public List<Restaurant> findRestaurantByType(RestaurantType type) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            TypedQuery<Restaurant> query = em.createQuery(
                    "SELECT r FROM Restaurant r WHERE r.type = :type", Restaurant.class);
            query.setParameter("type", type);
            return query.getResultList();
        } finally {
            JpaUtils.closeEntityManager();
        }
    }
}
