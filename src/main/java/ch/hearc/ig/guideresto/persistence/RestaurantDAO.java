package ch.hearc.ig.guideresto.persistence;

import ch.hearc.ig.guideresto.business.Restaurant;
import ch.hearc.ig.guideresto.business.RestaurantType;
import ch.hearc.ig.guideresto.business.City;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class RestaurantDAO extends GenericDAO<Restaurant, Integer> {

    public RestaurantDAO() {
        super(Restaurant.class);
    }


    // Method to find restaurants by name
    public List<Restaurant> findRestaurantByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Restaurant> query = session.createQuery(
                    "SELECT r FROM Restaurant r WHERE lower(r.name) LIKE :name", Restaurant.class);
            query.setParameter("name", "%" + name.toLowerCase() + "%");
            return query.list();
        }
    }

    // Method to find restaurants by city
    public List<Restaurant> findRestaurantsByCityName(String partialCityName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Restaurant> query = session.createQuery(
                    "SELECT r FROM Restaurant r JOIN r.city c " +
                            "WHERE lower(c.cityName) LIKE :partialCityName", Restaurant.class);
            query.setParameter("partialCityName", "%" + partialCityName.toLowerCase() + "%");
            return query.list();
        }
    }

    // Method to find restaurants by type
    public List<Restaurant> findRestaurantByType(RestaurantType type) {
        try (Session session = sessionFactory.openSession()) {
            Query<Restaurant> query = session.createQuery(
                    "SELECT r FROM Restaurant r WHERE r.type = :type", Restaurant.class);
            query.setParameter("type", type);
            return query.list();
        }
    }
}
