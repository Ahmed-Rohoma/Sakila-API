package iti.jets.repository.dao.interfaces;

import java.util.List;

public interface DaoInterface <K, E>{
    List<E> getAll();
    E getById(K id);
    void add(E entity);
    void update(E entity);
    void delete(K id);
}
