package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.City;
import jakarta.persistence.EntityManager;

public class CityDao extends BaseDao<Integer, City> {

    public CityDao(EntityManager entityManager) {
        super(entityManager, City.class);
    }

}
