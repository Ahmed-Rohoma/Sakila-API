package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.Payment;
import jakarta.persistence.EntityManager;

public class PaymentDao extends BaseDao<Integer, Payment> {

    public PaymentDao(EntityManager entityManager) {
        super(entityManager, Payment.class);
    }

}
