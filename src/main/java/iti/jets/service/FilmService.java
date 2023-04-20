package iti.jets.service;

import java.util.List;

import iti.jets.repository.connection.DBMananger;
import iti.jets.repository.dao.implementation.FilmDao;
import iti.jets.repository.entity.Actor;
import iti.jets.repository.entity.Film;
import iti.jets.repository.entity.FilmActor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class FilmService {

    private FilmDao filmDao = null;
    private EntityManagerFactory entityManagerFactory = DBMananger.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public FilmService() {
        filmDao = new FilmDao(entityManager);
    }

    public void update(Film film) {
        filmDao.update(film);
    }

    public Film getByID(int id) {
        return filmDao.getById(id);
    }

    public void add(Film film) {
        filmDao.add(film);
    }

    public void deleteByID(int id){
        filmDao.delete(id);
    }

    public List<Film> getAll() {
        return filmDao.getAll();
    }

    public void addActor(FilmActor actor,int id){
        filmDao.addActor(actor,id);
    }   

}
