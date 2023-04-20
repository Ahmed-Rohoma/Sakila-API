package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.Language;
import jakarta.persistence.EntityManager;

public class LanguageDao extends BaseDao<Integer, Language> {

    public LanguageDao(EntityManager entityManager) {
        super(entityManager, Language.class);
    }

}