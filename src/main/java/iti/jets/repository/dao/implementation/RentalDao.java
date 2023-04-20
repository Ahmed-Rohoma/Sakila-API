package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.Rental;
import jakarta.persistence.EntityManager;

public class RentalDao extends BaseDao<Integer, Rental> {

    public RentalDao(EntityManager entityManager) {
        super(entityManager, Rental.class);
    }

}
