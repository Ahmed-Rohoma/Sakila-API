package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.Country;
import jakarta.persistence.EntityManager;

public class CountryDao extends BaseDao<Integer, Country> {

    public CountryDao(EntityManager entityManager) {
        super(entityManager, Country.class);
    }

}
