package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.Customer;
import jakarta.persistence.EntityManager;

public class CustomerDao extends BaseDao<Integer, Customer> {

    public CustomerDao(EntityManager entityManager) {
        super(entityManager, Customer.class);
    }

}

