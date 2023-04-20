package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.Address;
import jakarta.persistence.EntityManager;

public class AddressDao extends BaseDao<Integer, Address> {

    public AddressDao(EntityManager entityManager) {
        super(entityManager, Address.class);
    }

}
