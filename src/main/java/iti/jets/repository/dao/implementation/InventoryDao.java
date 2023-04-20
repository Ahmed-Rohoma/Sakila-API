package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.Inventory;
import jakarta.persistence.EntityManager;

public class InventoryDao extends BaseDao<Integer, Inventory> {

    public InventoryDao(EntityManager entityManager) {
        super(entityManager, Inventory.class);
    }

}
