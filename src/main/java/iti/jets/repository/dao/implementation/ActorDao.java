package iti.jets.repository.dao.implementation;

import iti.jets.repository.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class ActorDao extends BaseDao<Integer, Actor> {

    EntityTransaction transaction = null;

    public ActorDao(EntityManager entityManager) {
        super(entityManager, Actor.class);
    }

    @Override
    public void delete(Integer id) {
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
        
            Actor actor = entityManager.find(Actor.class, id);
            Query deleteQuery = entityManager.createQuery("DELETE FROM FilmActor fa WHERE fa.actor = :actor");
            deleteQuery.setParameter("actor", actor);
            deleteQuery.executeUpdate();
        
            entityManager.remove(actor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    
        
    }

}
