package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.Staff;
import jakarta.persistence.EntityManager;

public class StaffDao extends BaseDao<Integer, Staff> {

    public StaffDao(EntityManager entityManager) {
        super(entityManager, Staff.class);
    }

}
