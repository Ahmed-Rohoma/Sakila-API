package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.FilmText;
import jakarta.persistence.EntityManager;

public class FilmTextDao extends BaseDao<Integer, FilmText> {

    public FilmTextDao(EntityManager entityManager) {
        super(entityManager, FilmText.class);
    }

}