package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.City;
import ch.hearc.ig.guideresto.persistence.CityDAO;
import ch.hearc.ig.guideresto.persistence.JpaUtils;

import java.util.Optional;

public class CityService extends GenericService<City, Integer> {

    private CityDAO cityDAO;

    public CityService() {
        super(City.class);
        this.cityDAO = new CityDAO();
    }

    public Optional<City> findCityByZipCode(String zipCode) {
        return JpaUtils.executeInTransaction(em -> cityDAO.findCityByZipCode(zipCode));
    }
}
