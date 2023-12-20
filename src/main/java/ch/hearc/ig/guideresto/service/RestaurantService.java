package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.Restaurant;
import ch.hearc.ig.guideresto.business.RestaurantType;
import ch.hearc.ig.guideresto.persistence.JpaUtils;
import ch.hearc.ig.guideresto.persistence.RestaurantDAO;

import java.util.List;

public class RestaurantService extends GenericService<Restaurant, Integer> {

    private RestaurantDAO restaurantDAO;

    public RestaurantService() {
        super(Restaurant.class);
        this.restaurantDAO = new RestaurantDAO();
    }

    public List<Restaurant> findRestaurantByName(String name) {
        return JpaUtils.executeInTransaction(em -> restaurantDAO.findRestaurantByName(name));
    }

    public List<Restaurant> findRestaurantsByCityName(String research) {
        return JpaUtils.executeInTransaction(em -> restaurantDAO.findRestaurantsByCityName(research));
    }

    public List<Restaurant> findRestaurantByType(RestaurantType chosenType) {
        return JpaUtils.executeInTransaction(em -> restaurantDAO.findRestaurantByType(chosenType));
    }
}
