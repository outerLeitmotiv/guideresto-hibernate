package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.RestaurantType;
import ch.hearc.ig.guideresto.persistence.JpaUtils;
import ch.hearc.ig.guideresto.persistence.RestaurantTypeDAO;

import java.util.Optional;

public class RestaurantTypeService extends GenericService<RestaurantType, Integer> {

    private RestaurantTypeDAO restaurantTypeDAO;

    public RestaurantTypeService() {
        super(RestaurantType.class);
        this.restaurantTypeDAO = new RestaurantTypeDAO();
    }

    public Optional<RestaurantType> findRestaurantTypeByType(String label) {
        return JpaUtils.executeInTransaction(em -> restaurantTypeDAO.findRestaurantTypeByType(label));
    }


}
