package ch.hearc.ig.guideresto.persistence;

import ch.hearc.ig.guideresto.business.RestaurantType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Optional;

public class RestaurantTypeDAO extends GenericDAO<RestaurantType, Integer> {

    public RestaurantTypeDAO() {
        super(RestaurantType.class);
    }

    // Method to find a restaurant type by its label
    public Optional<RestaurantType> findRestaurantTypeByType(String label) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            TypedQuery<RestaurantType> query = em.createQuery(
                    "SELECT rt FROM RestaurantType rt WHERE lower(rt.label) = :label",
                    RestaurantType.class);
            query.setParameter("label", label.toLowerCase());
            return Optional.ofNullable(query.getSingleResult());
        } catch (jakarta.persistence.NoResultException ex) {
            return Optional.empty();
        } finally {
            JpaUtils.closeEntityManager();
        }
    }
}
