package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.Category;
import jakarta.persistence.EntityManager;

public class CategoryDao extends BaseDao<Integer, Category> {

    public CategoryDao(EntityManager entityManager) {
        super(entityManager, Category.class);
    }

}