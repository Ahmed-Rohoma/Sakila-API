package iti.jets.service;

import java.util.List;

import iti.jets.repository.connection.DBMananger;
import iti.jets.repository.dao.implementation.FilmDao;
import iti.jets.repository.dao.implementation.LanguageDao;
import iti.jets.repository.entity.Film;
import iti.jets.repository.entity.Language;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class LanService {

    private LanguageDao lanDao = null;
    private EntityManagerFactory entityManagerFactory = DBMananger.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public LanService() {
        lanDao = new LanguageDao(entityManager);
    }

    public void update(Language lan) {
        lanDao.update(lan);
    }

    public Language getByID(int id) {
        return lanDao.getById(id);
    }

    public void add(Language lan) {
        lanDao.add(lan);
    }

    public void deleteByID(int id){
        lanDao.delete(id);
    }

    public List<Language> getAll() {
        return lanDao.getAll();
    }

}
