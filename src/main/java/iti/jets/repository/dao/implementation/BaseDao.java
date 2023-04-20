package iti.jets.repository.dao.implementation;


import iti.jets.repository.dao.interfaces.DaoInterface;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BaseDao<K, E> implements DaoInterface<K, E> {
    protected final EntityManager entityManager;
    private final Class<E> entityClass;

    public BaseDao(EntityManager entityManager, Class<E> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    @Override
    public List<E> getAll() {
        return entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }

    @Override
    public E getById(K id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public void add(E entity) {
        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(E entity) {
        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(K id) {
        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        entityManager.remove(getById(id));
        entityManager.getTransaction().commit();
    }
}