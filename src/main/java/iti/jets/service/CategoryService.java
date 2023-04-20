package iti.jets.service;


import java.util.List;

import iti.jets.model.dto.CategoryDTO;
import iti.jets.model.mapper.CategoryMapper;
import iti.jets.repository.connection.DBMananger;
import iti.jets.repository.dao.implementation.CategoryDao;
import iti.jets.repository.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class CategoryService {

    private CategoryDao categoryDao = null;
    private EntityManagerFactory entityManagerFactory = DBMananger.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public CategoryService() {
        categoryDao = new CategoryDao(entityManager);
    }

    public void update(Category category) {
        categoryDao.update(category);
    }

    public CategoryDTO getByID(int id) {
        return CategoryMapper.toDTO(categoryDao.getById(id));
    }

    public void add(Category category) {
        categoryDao.add(category);
    }

    public void deleteByID(int id){
        categoryDao.delete(id);
    }

    // public List<Film> CategoryFilms(int id){
        
    // }

}
