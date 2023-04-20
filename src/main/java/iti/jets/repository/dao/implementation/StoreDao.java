package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.Store;
import jakarta.persistence.EntityManager;

public class StoreDao extends BaseDao<Integer, Store> {

    public StoreDao(EntityManager entityManager) {
        super(entityManager, Store.class);
    }

}
