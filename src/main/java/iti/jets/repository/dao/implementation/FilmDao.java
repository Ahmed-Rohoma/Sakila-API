package iti.jets.repository.dao.implementation;

import java.util.HashSet;
import java.util.Set;

import iti.jets.repository.entity.Actor;
import iti.jets.repository.entity.Category;
import iti.jets.repository.entity.Film;
import iti.jets.repository.entity.FilmActor;
import iti.jets.repository.entity.FilmCategory;
import iti.jets.repository.entity.Language;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class FilmDao extends BaseDao<Integer, Film> {

    public FilmDao(EntityManager entityManager) {
        super(entityManager, Film.class);
    }

    @Override
    public void add(Film film) {

        try {
            if (film.getLanguage() != null && !entityManager.contains(film.getLanguage())) {
                System.out.println("HAS ");

                // entityManager.getTransaction().begin();
                // Language lan = entityManager.find(Language.class,
                // film.getLanguage().getId());
                // entityManager.getTransaction().commit();

                entityManager.getTransaction().begin();
                Language lan = entityManager.find(Language.class, 1);
                entityManager.getTransaction().commit();

                entityManager.getTransaction().begin();
                film.setLanguage(lan);
                entityManager.persist(film);
                entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            // entityManager.close();
        }
    }

    public void addActor(FilmActor actor, int filmId) {
        Set<FilmActor> actors = new HashSet<>();
        actors.add(actor);
        try {
            entityManager.getTransaction().begin();
            Film film = entityManager.find(Film.class, filmId);
            film.setFilmActors(actors);
            entityManager.merge(film);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
